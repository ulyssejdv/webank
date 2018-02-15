package fr.webank.front.android.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.webank.webankmodels.BankStatementDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import webank.http.hdfs.WebHdfsServiceBuilder;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by boubacarNDIAYE on 30/11/2017.
 */
@Service
public class AccountStatementService {
    public static final String REST_SERVICE_URI = "http://data-access-service:25000/data-access-service/bank-statement/customer/";

    public static BankStatementDto[] getResponseStatement(String endPath,
                                                          long id) {

        final String url = REST_SERVICE_URI + "/" + endPath + "/" + id;
        RestTemplate restTemplate2 = new RestTemplate();
        BankStatementDto[] result = restTemplate2.getForObject(url, BankStatementDto[].class);
        return result;
    }


}

