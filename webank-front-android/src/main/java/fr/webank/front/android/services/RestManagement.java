package fr.webank.front.android.services;

import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.TransactionDto;
import org.springframework.web.client.RestTemplate;


/**
 * @author EDERY Ruben.
 * Date     04/11/2017
 * Time     22:08
 */
public class RestManagement {

    /*private static String url;
    private static String port;
    private static String path;

    @Autowired
    public RestManagement(

            @Value("${client.services.urll}") String url,
            @Value("${client.services.port}") String port,
            @Value("${client.services.path}") String path) {
        this.port = port;
        this.url = url;
        this.path = path;
    }*/




    public static final String REST_SERVICE_URI = "http://data-access-service:25000/data-access-service";
   // public static final String REST_SERVICE_URI = url+port+path;

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
