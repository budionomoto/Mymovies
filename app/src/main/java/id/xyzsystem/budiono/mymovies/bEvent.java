package id.xyzsystem.budiono.mymovies;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class bEvent {
    private boolean success;
    private String message;
    private List<bModel> forecastList;

    public bEvent(boolean success, List<bModel> forecastList) {
        this.success = success;
        this.forecastList = forecastList;
    }

    public bEvent(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<bModel> getForecastList() {
        return forecastList;
    }
}
