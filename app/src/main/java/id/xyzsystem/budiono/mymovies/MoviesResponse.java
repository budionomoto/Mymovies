package id.xyzsystem.budiono.mymovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 21/01/18.
 * ini file keempat
 */

public class MoviesResponse {
    @SerializedName("list")
    private List<Forecast> forecastList;

    public List<Forecast> getForecastList() {
        return forecastList;
    }
}
