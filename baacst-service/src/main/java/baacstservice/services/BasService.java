package baacstservice.services;

import fr.webank.webankmodels.BasDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import webank.http.dataaccessservice.DataAccessServiceHttpClient;
import webank.http.dataaccessservice.DataAccessServiceBuilder;
import webank.http.hdfs.WebHdfsServiceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
@Log
@Service
public class BasService {

    private DataAccessServiceHttpClient service;

    @Autowired
    public BasService(@Value("${webank.data-access-service.url}") String dasUrl, @Value("${webank.data-access-service.port}") String dasPort) {

        log.info("dasUrl = " + dasUrl);
        log.info("dasPort = " + dasPort);
        service = DataAccessServiceBuilder.getService(dasUrl, dasPort);
    }

    public Optional<BasDto> getBas(Long id) {
        BasDto basDto = null;
        Call<BasDto> basObject = service.basObject(id);

        log.info(basObject.toString());

        // Synchronous way ...
        try {
            log.info("execute request");
            basDto = basObject.execute().body();
            basObject.request();
            log.info(basDto.toString());
            log.info("after execute request");
        } catch (IOException e) {
            log.info("BasService.getBas("+ id +") : Object Not Found");
        }

        log.info("return data from service");
        log.info(basDto.toString());

        return (basDto != null) ? Optional.of(basDto) : Optional.empty();
    }

    public List<BasDto> getBasByCustomer(Long customerId) {

        List<BasDto> basDtoList = null;

        Call<List<BasDto>> basCustomerList = service.basCustomerList(customerId);

        try {
            basDtoList = basCustomerList.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return basDtoList;
    }
}
