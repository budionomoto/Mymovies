package id.xyzsystem.budiono.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.daftar)
    RecyclerView Daftar;

    private bAdapter moviesAdapter;
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

        Daftar.setLayoutManager(new GridLayoutManager(this,2) );
        Daftar.setHasFixedSize(true);

        moviesAdapter = new bAdapter();
        Daftar.setAdapter(moviesAdapter);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveWeatherList(bEvent event) {
        if (event.isSuccess()) {
            List<bModel> forecasts = event.getForecastList();
            bModel todayForecast = forecasts.get(0);


            moviesAdapter.kirimData(forecasts);
        }else{

        }
    }

    //todo () panggil menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu );
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting){
            Toast.makeText(this, "ini menu", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }
}
