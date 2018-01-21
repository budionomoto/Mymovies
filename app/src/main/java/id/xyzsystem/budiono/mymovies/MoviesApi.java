package id.xyzsystem.budiono.mymovies;
//file ketiga yang dibuat
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by budiono on 21/01/18.
 */


//https://api.themoviedb.org/3/movie/now_playing?api_key=02c6bc54ddd867f7bcf339600faa7263&language=en-US&page=1
public interface MoviesApi {
    String BASE_URL = "http://api.themoviedb.org/3";
    String API_KEY = App.getInstance().getApplicationContext().getString(R.string.api_key_movies);

    @GET("movie/now_playing")
    Call<MoviesResponse> getDailyForecast(@Query("q") String cityName, @Query("mode") String mode, @Query("units") String unit, @Query("cnt") int countData, @Query("appid") String apiKey);

}
