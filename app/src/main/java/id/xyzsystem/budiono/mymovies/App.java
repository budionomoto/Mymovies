package id.xyzsystem.budiono.mymovies;
//ini file kedua

import android.app.Application;

import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;

/**
 * Created by budiono on 21/01/18.
 */

public class App extends Application {
    private static App instance;
    private EventBus eventBus;
    private Gson gson;
    private Retrofit retrofit;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createEventBus();
        createGson();
        createRetrofit();

    }
    private void createGson() {
        gson = new GsonBuilder().create();
    }

    private void createEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    private void createRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MoviesApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Gson getGson() {
        return gson;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public WeatherApi getWeatherApi() {
        return getRetrofit().create(WeatherApi.class);
    }

    public static App getInstance() {
        return instance;
    }
}
