package webank.http.hdfs;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by ulysse on 30/11/2017.
 */
public class WebHdfsServiceBuilder {

    public static byte[] run(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().bytes();
    }

}
