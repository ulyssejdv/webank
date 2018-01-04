package webank.http.hdfs;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by ulysse on 04/01/2018.
 */
@Slf4j
public class WebHdfsServiceBuilderTest {

    @Test(expected=ClientErrorException.class)
    public void sendHttpRequestShouldThrowAClientErrorException() throws IOException, ServerErrorException, ClientErrorException {

        final String url = "http://localhost";

        WebHdfsServiceBuilder webHdfsServiceBuilder = new WebHdfsServiceBuilder(
                url
        );


        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        Request mockedRequest = requestBuilder.build();

        Response.Builder responseBuilder = new Response.Builder();
        responseBuilder.code(404);
        responseBuilder.protocol(Protocol.HTTP_1_1);
        responseBuilder.request(mockedRequest);
        responseBuilder.message("message");

        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), "{\"error\": 0}");
        responseBuilder.body(responseBody);

        Response response = responseBuilder.build();

        Call mockedCall = mock(Call.class);
        when(mockedCall.execute()).thenReturn(response);

        OkHttpClient mockedOkHttpClient = mock(OkHttpClient.class);
        when(mockedOkHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);

        webHdfsServiceBuilder.setClient(mockedOkHttpClient);

        webHdfsServiceBuilder.sendHttpRequest();
    }


    @Test(expected=ServerErrorException.class)
    public void sendHttpRequestShouldThrowAServerErrorException() throws IOException, ServerErrorException, ClientErrorException {

        final String url = "http://localhost";

        WebHdfsServiceBuilder webHdfsServiceBuilder = new WebHdfsServiceBuilder(
                url
        );


        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        Request mockedRequest = requestBuilder.build();

        Response.Builder responseBuilder = new Response.Builder();
        responseBuilder.code(500);
        responseBuilder.protocol(Protocol.HTTP_1_1);
        responseBuilder.request(mockedRequest);
        responseBuilder.message("message");

        ResponseBody responseBody = ResponseBody.create(MediaType.parse("text/html"), "blabla");
        responseBuilder.body(responseBody);

        Response response = responseBuilder.build();

        Call mockedCall = mock(Call.class);
        when(mockedCall.execute()).thenReturn(response);

        OkHttpClient mockedOkHttpClient = mock(OkHttpClient.class);
        when(mockedOkHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);

        webHdfsServiceBuilder.setClient(mockedOkHttpClient);

        webHdfsServiceBuilder.sendHttpRequest();
    }


    @Test()
    public void sendHttpRequestShouldReturnAnArrayOfBytes() throws IOException, ServerErrorException, ClientErrorException {

        final String url = "http://localhost";

        final String pdfContent = "Hello";

        WebHdfsServiceBuilder webHdfsServiceBuilder = new WebHdfsServiceBuilder(
                url
        );


        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        Request mockedRequest = requestBuilder.build();

        Response.Builder responseBuilder = new Response.Builder();
        responseBuilder.code(200);
        responseBuilder.protocol(Protocol.HTTP_1_1);
        responseBuilder.request(mockedRequest);
        responseBuilder.message("message");



        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/octet-stream"), pdfContent);
        responseBuilder.body(responseBody);

        Response response = responseBuilder.build();

        Call mockedCall = mock(Call.class);
        when(mockedCall.execute()).thenReturn(response);

        OkHttpClient mockedOkHttpClient = mock(OkHttpClient.class);
        when(mockedOkHttpClient.newCall(any(Request.class))).thenReturn(mockedCall);

        webHdfsServiceBuilder.setClient(mockedOkHttpClient);

        Assert.assertArrayEquals(pdfContent.getBytes(), webHdfsServiceBuilder.sendHttpRequest());
    }

}