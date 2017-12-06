package service;

import fr.webank.webankmodels.BasDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webank.http.hdfs.WebHdfsServiceBuilder;

import java.io.IOException;

/**
 * Created by boubacar on 30/11/2017.
 */
@Log
@Service
public class AccountStatementService {

    private String url;
    private String port;
    private String path;
    private String service;

    @Autowired
    public AccountStatementService(

            @Value("${baacst.service.url}") String url, @Value("${baacst.service.port}") String port, @Value("${baacst.service.path}") String path, @Value("${baacst.service.service}") String service) {
        this.port = port;
        this.url = url;
        this.path = path;
        this.service = service;
    }

    //http://10.168.1.4:25100/baacst-service/pdf/1/customer/1
    public byte[] getMyPDF(Long customerId) {
        byte[] pdf = null;
        StringBuilder fullUrl = new StringBuilder();
        fullUrl.append(this.url).append(":").append(port).append(this.service);
        fullUrl.append(this.path).append("/" + customerId).append("/customer/").append(customerId);
        log.info(fullUrl.toString());
        try {
            pdf = WebHdfsServiceBuilder.run(fullUrl.toString());
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        log.info(pdf.toString());
        return pdf;
    }

    public byte[] getMyJsonDocumnt(Long customerId) {
        byte[] pdf = null;
        StringBuilder fullUrl = new StringBuilder();
        fullUrl.append(this.url).append(":").append(port).append(this.service).
        append("/").append(customerId);
        log.info(fullUrl.toString());
        try {
            pdf = WebHdfsServiceBuilder.run(fullUrl.toString());
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        log.info(pdf.toString());
        return pdf;
    }

}
