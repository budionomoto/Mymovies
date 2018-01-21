package id.xyzsystem.budiono.mymovies;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by budiono on 21/01/18.
 * file ke -6
 */

//public class MoviesAdapter {
public class MoviesAdapter extends RecyclerView.Adapter {
    List<Forecast> forecasts;

    public MoviesAdapter() {
        forecasts = new ArrayList<>();
    }

}
