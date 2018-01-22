package id.xyzsystem.budiono.mymovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by budiono on 22/01/18.
 */

public interface bInterface {

    //String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String BASE_URL = "https://api.themoviedb.org/3/movie/";
    //String API_KEY = bAplikasi.ambilInstance().getApplicationContext().getString(R.string.api_key_movies);
    String API_KEY = bAplikasi.ambilInstance().getApplicationContext().getString(R.string.api_key_movies);

    @GET("now_playing")
    Call<bResponse> ambilMovies(
            @Query("api_key") String apiKey,
            @Query("language") String bahasa,
            @Query("page") int halaman);
}
