package id.xyzsystem.budiono.mymovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 21/01/18.
 */

public class Forecast {
    @SerializedName("Movies")
    private List<Movies> moviesList;

    public class Movies{
        @SerializedName("poster_path")
        private String moviesGambar;
    }

    public List<Movies> getMoviesList() {
        return moviesList;
    }
}
