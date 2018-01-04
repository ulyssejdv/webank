package baacstservice.services;

import fr.webank.webankmodels.BasDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import webank.http.dataaccessservice.DataAccessServiceHttpClient;
import webank.http.dataaccessservice.DataAccessServiceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
@Slf4j
@Service
public class BasService {

    private DataAccessServiceHttpClient service;

    @Autowired
    public BasService(
            @Value("${webank.data-access-service.url}") String dasUrl,
            @Value("${webank.data-access-service.port}") String dasPort
    ) {
        service = DataAccessServiceBuilder.getService(dasUrl, dasPort);
    }

    public Optional<BasDto> getBas(Long id) {
        BasDto basDto = null;
        Call<BasDto> basObject = service.basObject(id);
        try {
            basDto = basObject.execute().body();
            basObject.request();
        } catch (IOException e) {
            // TODO : exception
            log.error("Erreur with the http request to hdfs");
        }
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
