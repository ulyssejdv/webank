package webank.http.hdfs;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by ulysse on 30/11/2017.
 */
@Slf4j
public class WebHdfsServiceBuilder {

    public static byte[] run(String url) throws ClientErrorException, ServerErrorException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;

        try {
            log.debug("pre execute : " + url);
            response = client.newCall(request).execute();
            log.debug("post execute");
        } catch (IOException e) {
            log.error("Error in execute()");
            log.error(e.getMessage());
        }

        int httpStatusCode = response.code();


        String msg = "Get " + String.valueOf(httpStatusCode) + " in http response code";

        log.info(msg);

        if (httpStatusCode >= 400 && httpStatusCode < 500) {
            throw new ClientErrorException("Client Error" + msg);
        } else if (httpStatusCode >= 500 && httpStatusCode < 600) {
            throw new ServerErrorException("Server Error" + msg);
        }

        byte[] pdf = null;

        try {
            pdf = response.body().bytes();
        } catch (IOException e) {
            log.error("Error in body().bytes()");
            log.error(e.getMessage());
        }

        return pdf;
    }

}
