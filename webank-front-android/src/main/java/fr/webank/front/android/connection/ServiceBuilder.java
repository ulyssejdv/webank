package fr.webank.front.android.connection;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by ulysse on 30/11/2017.
 */
@Slf4j
public class ServiceBuilder {


    private OkHttpClient client;

    private Request request;

    private Response response;

    private String url;



    public ServiceBuilder(String url) {
        this.url = url;
        this.client = new OkHttpClient();
        this.request = new Request.Builder().url(this.url).build();
        this.response = null;
    }



    public  byte[] sendHttpRequest() throws Exception {

        try {
            log.info("HTTP Request to : " + this.url);
            Call call = this.client.newCall(this.request);
            this.response = call.execute();
        } catch (IOException e) {
            log.error("Error in execute()");
            log.error(e.getMessage());
        }

        int httpStatusCode = response.code();

        String msg = "Get " + String.valueOf(httpStatusCode) + " in http response code";

        log.info(msg);

        if (httpStatusCode >= 400 && httpStatusCode < 500) {
            throw new Exception(response.body().string());
        } else if (httpStatusCode >= 500 && httpStatusCode < 600) {
            throw new Exception(response.body().string());
        }

        byte[] pdf = null;

        try {
            pdf = response.body().bytes();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return pdf;
    }



    public void setClient(OkHttpClient client) {
        this.client = client;
    }
}
