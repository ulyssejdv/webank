package fr.webank.dataaccessservice.services.machine.learning;

import fr.webank.dataaccessservice.entities.HistoriqueSolde;
import fr.webank.dataaccessservice.repositories.HistoriqueSoldeRepository;
import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.HistoriqueSoldeDto;
import fr.webank.webankmodels.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PredictionSoldeService {
    private final HistoriqueSoldeRepository HistoriqueSoldeRepository;

    // constructor
    // @Autowired : dependency injection
    @Autowired
    public PredictionSoldeService(HistoriqueSoldeRepository historiqueSoldeRepository) {
        this.HistoriqueSoldeRepository = historiqueSoldeRepository;
    }
    // get list stock from data base
    public Page<HistoriqueSoldeDto> getSoldeCourant(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);

        Page<HistoriqueSoldeDto> listhistorique = HistoriqueSoldeRepository.distinctUser(pageable)
                .map(
                        // builder: create a new instance stockdto
                        // -> the mapping
                        historique -> HistoriqueSoldeDto.builder()
                                .idClient(historique.getIdClient())
                                .name(historique.getName())
                                .month(historique.getMonth())
                                .year(historique.getYear())
                                .solde(historique.getSolde())
                                .nbChildren(historique.getNbChildren())
                                .categorieDesc(historique.getCategorieDesc())
                                // build() : finalize the creation of new instance
                                .build()
                );
        // return the list of stocks
        return listhistorique;
    }

    public List<HistoriqueSoldeDto> getLastYear(Long idClient) {

        Pageable pageable = new PageRequest(0, 12);

        Page<HistoriqueSoldeDto> listhistorique = HistoriqueSoldeRepository.GetHistory(idClient, pageable)
                .map(
                        // builder: create a new instance stockdto
                        // -> the mapping
                        historique -> HistoriqueSoldeDto.builder()
                                .idClient(historique.getIdClient())
                                .name(historique.getName())
                                .month(historique.getMonth())
                                .year(historique.getYear())
                                .solde(historique.getSolde())
                                .nbChildren(historique.getNbChildren())
                                .categorieDesc(historique.getCategorieDesc())
                                // build() : finalize the creation of new instance
                                .build()
                );
        // return the list of stocks
        return listhistorique.getContent();
    }

    public List<HistoriqueSoldeDto> predictNextYear(Long idClient) throws IOException, InterruptedException {

        File scriptFile = new File("script.R");

        if(!scriptFile.exists()) {
            PrintWriter scriptPw = new PrintWriter(scriptFile);

            String script ="#!/usr/bin/env Rscript\n" +
                    "args = commandArgs(trailingOnly=TRUE)\n" +
                    "\n" +
                    "data <- read.csv(file=args[1], header=TRUE, sep=\",\", encoding=\"UTF-8\")\n" +
                    "datapred <- read.csv(file=args[2], header=TRUE, sep=\",\", encoding=\"UTF-8\")\n" +
                    "library(methods)\n" +
                    "library(Matrix)\n" +
                    "library(lme4)\n" +
                    "model2 <- lmer(data = data, SOLDE ~ MOIS + ENFANTS + ANNEE + (1| IDCLIENT))\n" +
                    "datapred[,\"SOLDE\"] = predict(model2, newdata = datapred)\n" +
                    "write.csv(datapred, file = args[2]);\n";

            scriptPw.write(script);
            scriptPw.close();
        }

        UUID uuid = UUID.randomUUID();

        Pageable pageable = new PageRequest(0, 1);

        Page<HistoriqueSolde> listhistorique = HistoriqueSoldeRepository.GetHistory(idClient, pageable);

        HistoriqueSolde lastSolde = listhistorique.getContent().get(0);

        List<HistoriqueSolde> listhistoriqueByCategorie = HistoriqueSoldeRepository.GetHistoryByCategorie(lastSolde.getCategorie());

        File testFile = new File(uuid + "train.csv");

        PrintWriter pw = new PrintWriter(testFile);

        StringBuilder sb = new StringBuilder();
        sb.append("IDCLIENT");
        sb.append(',');
        sb.append("MOIS");
        sb.append(',');
        sb.append("ANNEE");
        sb.append(',');
        sb.append("ENFANTS");
        sb.append(',');
        sb.append("CATEGORIE");
        sb.append(',');
        sb.append("SOLDE");
        sb.append('\n');

        for(int i = 0; i< listhistoriqueByCategorie.size(); i++) {
            HistoriqueSolde historiqueSolde = listhistoriqueByCategorie.get(i);


            sb.append(historiqueSolde.getIdClient());
            sb.append(',');
            sb.append(historiqueSolde.getMonth());
            sb.append(',');
            sb.append(historiqueSolde.getYear());
            sb.append(',');
            sb.append(historiqueSolde.getNbChildren());
            sb.append(',');
            sb.append(historiqueSolde.getCategorie());
            sb.append(',');
            sb.append(historiqueSolde.getSolde());
            sb.append('\n');

        }

        pw.write(sb.toString());
        pw.close();

        File testpred = new File(uuid + "train_pred.csv");
        pw = new PrintWriter(testpred);

        sb = new StringBuilder();
        sb.append("IDCLIENT");
        sb.append(',');
        sb.append("MOIS");
        sb.append(',');
        sb.append("ANNEE");
        sb.append(',');
        sb.append("ENFANTS");
        sb.append(',');
        sb.append("CATEGORIE");
        sb.append('\n');

        LocalDate futureDate = LocalDate.now();

        for(int i = 1; i<= 12; i++) {
            futureDate = futureDate.plusMonths(1);

            futureDate.getMonth();

            sb.append(lastSolde.getIdClient());
            sb.append(',');
            sb.append(futureDate.getMonthValue());
            sb.append(',');
            sb.append(futureDate.getYear());
            sb.append(',');
            sb.append(lastSolde.getNbChildren() - 1);
            sb.append(',');
            sb.append(lastSolde.getCategorie());
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();

        //String fileLocationScript =  new ClassPathResource("script/script.R").getFile().getAbsolutePath();

        String cmd = "/usr/bin/Rscript --vanilla " + scriptFile.getAbsolutePath() + " " + testFile.getAbsolutePath() + " " + testpred.getAbsolutePath();
        Process child = Runtime.getRuntime().exec(cmd);

        int code = child.waitFor();

        List<HistoriqueSoldeDto> listPrediction = new ArrayList<>();

        if(code == 0) {
            BufferedReader br = new BufferedReader(new FileReader(testpred.getAbsoluteFile()));

            String st = "";
            br.readLine();
            while ((st = br.readLine()) != null) {

                String[] data = st.split(",");
                if(data.length == 7) {
                    listPrediction.add(new HistoriqueSoldeDto(
                            Long.parseLong(data[1]),
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            Double.parseDouble(data[6].split("\\.")[0])));
                }
            }
        }

        testFile.delete();
        testpred.delete();

        return listPrediction;
    }


}
