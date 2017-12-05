package controller;

import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.TransactionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


/**
 * @author EDERY Ruben
 * Date     04/11/2017
 * Time     22:08
 */
public class RestManagement {

    //@Value("${client.service.url}") static String url;
    //@Value("${client.service.port}") static String port;
    //@Value("${client.service.path}") static String path;



    public static final String REST_SERVICE_URI = "http://localhost:25000/data-access-service/";
    //public static final String REST_SERVICE_URI = url+port+path;

    public static AccountDto[] getResponse(String endPath,
                                           long id){

        final String url = REST_SERVICE_URI + "/" + endPath + "/" +id;
        RestTemplate restTemplate2 = new RestTemplate();
        AccountDto[] result = restTemplate2.getForObject(url,AccountDto[].class);
        return result;
    }


    public static TransactionDto[] getResponseTransaction(String endPath,
                                                          long id){

        final String url = REST_SERVICE_URI + "/" + endPath + "/" +id;
        RestTemplate restTemplate2 = new RestTemplate();
        TransactionDto[] result = restTemplate2.getForObject(url,TransactionDto[].class);
        return result;
    }


}
