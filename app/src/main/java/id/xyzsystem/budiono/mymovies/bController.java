package id.xyzsystem.budiono.mymovies;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by budiono on 22/01/18.
 */

public class bController {
    private static final String TAG = "MoviesController";
    private EventBus eventBus = bAplikasi.ambilInstance().ambilEventBus();

    public void getWeatherList() {
        Call<bResponse> dailyForecast =
                bAplikasi.ambilInstance().ambilMoviesApi().ambilMovies
                        ("02c6bc54ddd867f7bcf339600faa7263"
                                , "en-US"
                                , 1);

        dailyForecast.enqueue(
            new Callback<bResponse>() {
                @Override
                public void onResponse(Call<bResponse> call, Response<bResponse> response) {
                    Log.d(TAG, "onResponse: Success");
                    Log.d(TAG, "onResponse: JSON = " + bAplikasi.ambilInstance().ambilGson().toJson(response.body()));

                    List<bModel> forecastList = response.body().ambilmodelList();
                    bEvent moviesEvent = new bEvent(true, forecastList);
                    eventBus.post(moviesEvent);
                }

                @Override
                public void onFailure(Call<bResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure: Failed");
                    Log.e(TAG, "onFailure: Message = " + t.getMessage());
                    bEvent weatherEvent = new bEvent(false, t.getMessage());
                    eventBus.post(weatherEvent);
                }
            }
        );
    }
}
