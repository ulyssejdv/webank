package fr.webank.hdfs.service.services;

import fr.webank.hdfs.service.common.HdfsUrl;
import fr.webank.hdfs.service.exceptions.PdfNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webank.http.hdfs.ClientErrorException;
import webank.http.hdfs.ServerErrorException;
import webank.http.hdfs.WebHdfsServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ulysse on 30/11/2017.
 */
@Slf4j
@Service
public class BankStatementHdfsService {

    private static final String FILE_EXTENSION = ".pdf";

    @Value("${webank.hdfs.namenode}")
    private String nameNode;

    @Value("${webank.hdfs.bank-statement-url}")
    private String bankStatementUrl;


    /**
     * Get a PDF file from HDFS
     *
     * @param fileName
     * @return pdf file in array of bytes
     */
    public byte[] getBankStatementPdf(String fileName) throws PdfNotFoundException {

        byte[] pdf = null;

        StringBuilder basePathWithFileName = new StringBuilder();
        basePathWithFileName.append(this.bankStatementUrl);
        basePathWithFileName.append(fileName);
        basePathWithFileName.append(BankStatementHdfsService.FILE_EXTENSION);

        List<String> hdfsUrlparams = new ArrayList<String>();
        hdfsUrlparams.add("op=OPEN");
        hdfsUrlparams.add("user.name=hdfs");

        HdfsUrl hdfsUrl = new HdfsUrl(
                this.nameNode,
                basePathWithFileName.toString(),
                hdfsUrlparams
        );

        try {
            pdf = WebHdfsServiceBuilder.sendHttpRequest(hdfsUrl.buildStringUrl());
        } catch (ServerErrorException | ClientErrorException e) {
            log.error(e.getMessage());
            throw new PdfNotFoundException(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return pdf;
    }
}
