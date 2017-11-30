package webank.http.dataaccessservice;

import fr.webank.webankmodels.BasDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by ulysse on 29/11/2017.
 */
public interface DataAccessServiceHttpClient {

    @GET("data-access-service/bas/{id}")
    Call<BasDto> basObject(@Path("id") Long id);

    @GET("data-access-service/bas/customer/{id}")
    Call<List<BasDto>> basCustomerList(@Path("id") Long id);
}
