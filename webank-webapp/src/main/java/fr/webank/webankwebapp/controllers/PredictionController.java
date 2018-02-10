package fr.webank.webankwebapp.controllers;

import fr.webank.webankmodels.HistoriqueSoldeDto;
import fr.webank.webankmodels.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.webankmodels.CustomerDto;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prediction")
public class PredictionController {

    private final String baseurl = "http://localhost:25000/data-access-service/prediction";

    @RequestMapping(value="/{clientId}",method = {RequestMethod.GET})
    public ModelAndView getPrediction(@PathVariable Long clientId) {

        ModelAndView mav = new ModelAndView("prediction/prediction");
        RestTemplate restTemplate = new RestTemplate();
        String url = baseurl + "/" + clientId;
        HistoriqueSoldeDto[] listHistoryDto = restTemplate.getForObject(url, HistoriqueSoldeDto[].class);

        String tabDateHistorique= "";

        for (HistoriqueSoldeDto historyDto:listHistoryDto) {
            tabDateHistorique += "['" + historyDto.getMonth() +"/1/"+  historyDto.getYear() + "',"  + historyDto.getSolde() + "], ";
        }

        tabDateHistorique = "[" + tabDateHistorique.substring(0, tabDateHistorique.length() -1) + "]";

        mav.addObject("tabDateHistorique", tabDateHistorique);

        HistoriqueSoldeDto[] listHistoryPredictionDto = restTemplate.getForObject(url + "/prediction", HistoriqueSoldeDto[].class);

        String tabDatePrediction= "";

        for (HistoriqueSoldeDto historyPrediction:listHistoryPredictionDto) {
            tabDatePrediction += "['" + historyPrediction.getMonth() +"/1/"+  historyPrediction.getYear() + "',"  + historyPrediction.getSolde() + "], ";
        }

        tabDatePrediction = "[" + tabDatePrediction.substring(0, tabDatePrediction.length() -1) + "]";

        mav.addObject("tabDatePrediction", tabDatePrediction);

        mav.addObject("listHistoryPrediction", listHistoryPredictionDto);


        return mav;
    }

    @RequestMapping(value="",method = {RequestMethod.GET})
    public ModelAndView getListeClient() {

        ModelAndView mav = new ModelAndView("prediction/listclients");
        RestTemplate restTemplate = new RestTemplate();
        String url = baseurl + "/";
        Page<HistoriqueSoldeDto> listClientDto = restTemplate.getForObject(url, Page.class);

        mav.addObject("listClientDto", listClientDto);


        return mav;

    }
}
