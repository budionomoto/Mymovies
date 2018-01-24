package id.xyzsystem.budiono.mymovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by budiono on 22/01/18.
 */

// bentuk pertama, normal
//public class bHolder extends RecyclerView.ViewHolder{

// bentuk kedua ketika sudah ditambah onclick (implements)
public class bHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @BindView(R.id.gambar)
    ImageView imgGambar;

    @BindView(R.id.judul)
    TextView txtJudul;

    @BindView(R.id.tanggal)
    TextView txtTanggal;

    private static final int moviesLayout = R.layout.view_holder_movies;
    private final MoviesCallback callback;

    // bentuk ketika belum ditambah callback
    //public bHolder(View itemView) {
    //bentuk ketika sudah ditambah call back
    public bHolder(View itemView, MoviesCallback  callBack) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.callback = callBack;
        itemView.setOnClickListener(this);
    }

    public TextView ambilJudul() {
        return txtJudul;
    }

    public ImageView ambilGambar() {
        return imgGambar;
    }

    public TextView ambilTanggal(){
        return txtTanggal;
    }
    public static int ambilLayout() {
        return moviesLayout;
    }

    @Override
    public void onClick(View v) {
        callback.onMoviesClick(this);
    }

    // tambahan interface untuk call back
    public interface MoviesCallback {
        // todo () : global untuk klik
        void onMoviesClick(bHolder holder);
    }
}
