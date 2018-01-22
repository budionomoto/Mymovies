package id.xyzsystem.budiono.mymovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class bModel {
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;


    @SerializedName("results")
    private List<Movies> moviesList;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public class Movies {
        @SerializedName("title")
        private String moviesJudul;

        @SerializedName("poster_path")
        private String moviesGambar;


        public String ambilJudul() {
            return moviesJudul;
        }

        public String ambilGambar() {
            return moviesGambar;
        }
    }
    public List<Movies> getMoviesList() {
        return moviesList;
    }
}
