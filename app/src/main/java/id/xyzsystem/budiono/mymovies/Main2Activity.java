package id.xyzsystem.budiono.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.sinopsis)
    TextView Sinopsis;

    @BindView(R.id.judul)
    TextView Judul;

    @BindView(R.id.gambar)
    ImageView Gambar;

    @BindView(R.id.rating)
    TextView Rating;

    private String shareContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bHolder holder;
        ButterKnife.bind(this);

        String nomerJson = getIntent().getStringExtra("nomerjson");
        bModel paketData = bAplikasi.ambilInstance().ambilGson().fromJson(nomerJson, bModel.class);

        Judul.setText(paketData.getTitle());
        Sinopsis.setText(paketData.getSinopsis());

        bFunction.setImageResource(
                this,
                bFunction.ambilMoviesImageUrl(paketData.getPosterPath()) ,
                Gambar);

        Rating.setText(paketData.getRating()  + " of 10");

        shareContent = "Title:" + paketData.getTitle()
                + ", Description: " + paketData.getSinopsis()
                + ", Release: " + paketData.getTanggal()
                + ", Rating: " + paketData.getRating();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {
            shareMovies();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
        //return super.onOptionsItemSelected(item);
    }

    private void shareMovies() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareContent);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
