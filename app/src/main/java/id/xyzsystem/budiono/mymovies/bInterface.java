package id.xyzsystem.budiono.mymovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by budiono on 22/01/18.
 */

public interface bInterface {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = bAplikasi.ambilInstance().getApplicationContext().getString(R.string.api_key_weather);

    @GET("forecast/daily")
    Call<bResponse> getDailyForecast(@Query("q") String cityName, @Query("mode") String mode, @Query("units") String unit, @Query("cnt") int countData, @Query("appid") String apiKey);

}
