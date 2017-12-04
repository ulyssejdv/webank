package baacstservice.services;

import fr.webank.webankmodels.BasDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webank.http.hdfs.WebHdfsServiceBuilder;

import java.io.IOException;

/**
 * Created by ulysse on 30/11/2017.
 */
@Log
@Service
public class PdfService {

    private String hdfsUrl;
    private String hdfsPort;
    private String hdfsApi;
    private String hdfsPath;

    @Autowired
    public PdfService(
            @Value("${webank.hdfs.master.url}") String hdfsUrl,
            @Value("${webank.hdfs.master.port}") String hdfsPort,
            @Value("${webank.hdfs.master.api}") String hdfsApi,
            @Value("${webank.hdfs.master.bas.path}") String hdfsPath
    ) {
        this.hdfsUrl = hdfsUrl;
        this.hdfsPort = hdfsPort;
        this.hdfsApi = hdfsApi;
        this.hdfsPath = hdfsPath;
    }

    public byte[] getPdf(BasDto basDto, Long customerId) {
        byte[] pdf = null;

        StringBuilder fullUrl = new StringBuilder();

        fullUrl.append(this.hdfsUrl).append(":").append(hdfsPort).append(hdfsApi);
        fullUrl.append(this.hdfsPath).append(customerId).append("/");
        fullUrl.append(basDto.getFileName());
        fullUrl.append("?op=OPEN&user.name=hdfs");

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
