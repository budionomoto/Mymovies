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

    @SerializedName("release_date")
    private  String tanggal;

    //detail
    @SerializedName("overview")
    private String sinopsis;

    @SerializedName("vote_average")
    private String rating;


    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getRating() {
        return rating;
    }

//    @SerializedName("results")
//    private List<Movies> moviesList;

//    public class Movies {
        /*
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
        */
//    }

//    public List<Movies> getMoviesList() {
//        return moviesList;
//    }

}
