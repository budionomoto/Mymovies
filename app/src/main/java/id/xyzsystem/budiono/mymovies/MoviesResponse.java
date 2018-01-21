package id.xyzsystem.budiono.mymovies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by budiono on 21/01/18.
 * ini file keempat
 */

public class MoviesResponse {
    @SerializedName("list")
    private List<Now> forecastList;

    public List<Forecast> getForecastList() {
        return forecastList;
    }
}
