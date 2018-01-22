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

public class bHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.gambar)
    ImageView imgGambar;

    @BindView(R.id.judul)
    TextView txtJudul;

    private static final int moviesLayout = R.layout.view_holder_movies;

    public bHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public TextView ambilJudul() {
        return txtJudul;
    }

    public ImageView ambilGambar() {
        return imgGambar;
    }
    public static int ambilLayout() {
        return moviesLayout;
    }
}
