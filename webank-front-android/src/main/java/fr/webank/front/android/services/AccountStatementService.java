package fr.webank.front.android.services;


import fr.webank.front.android.connection.ServiceBuilder;
import fr.webank.webankmodels.BankStatementDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.ArrayList;
import java.util.List;


/**
 * Created by boubacarNDIAYE on 30/11/2017.
 */
@Slf4j
@Service
public class AccountStatementService {
    public static final String REST_SERVICE_URI = "http://data-access-service:25000/data-access-service/bank-statement/customer";

    public static BankStatementDto[] getResponseStatement(String endPath,
                                                          long id) {

        final String url = REST_SERVICE_URI + "/" + id;
        RestTemplate restTemplate2 = new RestTemplate();
        BankStatementDto[] result = restTemplate2.getForObject(url, BankStatementDto[].class);
        return result;
    }


    //

    public static final String REST_SERVICE_URIPDF = "http://webank-hdfs-service:25100/webank-hdfs-service/bank-statement/";

    public static byte[] getResponseStatementpdf (String filename
                                                         )throws Exception {

String url =REST_SERVICE_URIPDF+filename+".pdf";

            StringBuilder basePathWithFileName = new StringBuilder();
            basePathWithFileName.append(url);
byte[] pdf=null;
            List<String> hdfsUrlparams = new ArrayList<String>();
            hdfsUrlparams.add("op=OPEN");
            hdfsUrlparams.add("user.name=hdfs");
        ServiceBuilder serviceBuildererviceBuilder = new ServiceBuilder(url);
            try {

                  pdf   = serviceBuildererviceBuilder.sendHttpRequest();

            }catch (Exception e){

            }
        return pdf;
        }
    }



