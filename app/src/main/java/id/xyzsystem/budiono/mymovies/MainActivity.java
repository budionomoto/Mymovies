package id.xyzsystem.budiono.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import org.greenrobot.eventbus.EventBus;


// ini file pertama yg dibuat
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.daftar)
    RecyclerView moviesDaftar;

    private EventBus eventBus = App.getInstance().getEventBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventBus.register(this);

        initView();
    }

    private void initView(){
        ButterKnife.bind(this);

        moviesDaftar.setLayoutManager(new LinearLayoutManager(this));
    }
}
