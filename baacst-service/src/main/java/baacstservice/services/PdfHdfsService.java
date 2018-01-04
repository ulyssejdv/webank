package baacstservice.services;

import fr.webank.webankmodels.BasDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webank.http.hdfs.ClientErrorException;
import webank.http.hdfs.ServerErrorException;
import webank.http.hdfs.WebHdfsServiceBuilder;

/**
 * Created by ulysse on 30/11/2017.
 */
@Slf4j
@Service
public class PdfHdfsService {

    private String nameNode;
    private String secondaryNameNode;
    private String[] dataNodes;
    private String basUrl;

    @Autowired
    public PdfHdfsService(
            @Value("${webank.hdfs.namenode}") String nameNode,
            @Value("${webank.hdfs.secondary-namenode}") String secondaryNameNode,
            @Value("#{'${webank.hdfs.datanodes}'.split(',')}") String[] dataNodes,
            @Value("${webank.hdfs.bas-url}") String basUrl
    ) {
        this.nameNode = nameNode;
        this.secondaryNameNode = secondaryNameNode;
        this.dataNodes = dataNodes;
        this.basUrl = basUrl;
    }

    public byte[] getPdf(BasDto basDto, Long customerId) {
        byte[] pdf = null;

        StringBuilder fullUrl = new StringBuilder();

        fullUrl.append(this.nameNode);
        fullUrl.append(this.basUrl).append(customerId).append("/");
        fullUrl.append(basDto.getFileName());
        fullUrl.append("?op=OPEN&user.name=hdfs");

        log.info(fullUrl.toString());

        try {
            pdf = WebHdfsServiceBuilder.run(fullUrl.toString());
        } catch (ServerErrorException e) {


            log.error(e.getMessage());
            log.info("Try with the secondary namenode");

            StringBuilder fullUrl2 = new StringBuilder();

            fullUrl2.append(this.secondaryNameNode);
            fullUrl2.append(this.basUrl).append(customerId).append("/");
            fullUrl2.append(basDto.getFileName());
            fullUrl2.append("?op=OPEN&user.name=hdfs");

            try {
                pdf = WebHdfsServiceBuilder.run(fullUrl.toString());
            } catch (ClientErrorException e1) {
                log.error("error with the secondary namenode :(");
                log.error(e1.getMessage());
            } catch (ServerErrorException e1) {
                log.error(e1.getMessage());
            }

        } catch (ClientErrorException e) {
            log.error(e.getMessage());
        }

        return pdf;
    }

}
