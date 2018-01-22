package id.xyzsystem.budiono.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_weather_list)
    RecyclerView mainWeatherList;

    private bAdapter weatherAdapter;
    private EventBus eventBus = bAplikasi.ambilInstance().ambilEventBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventBus.register(this);
        initView();

        bController controller = new bController();
        controller.getWeatherList();
    }
    @Override
    protected void onDestroy() {
        eventBus.unregister(this);
        super.onDestroy();
    }

    private void initView() {
        ButterKnife.bind(this);

        mainWeatherList.setLayoutManager(new GridLayoutManager(this,2) );
        mainWeatherList.setHasFixedSize(true);

        weatherAdapter = new bAdapter();
        mainWeatherList.setAdapter(weatherAdapter);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveWeatherList(bEvent event) {
        if (event.isSuccess()) {
            List<bModel> forecasts = event.getForecastList();
            bModel todayForecast = forecasts.get(0);


            weatherAdapter.kirimData(forecasts);
        }else{

        }
    }
}
