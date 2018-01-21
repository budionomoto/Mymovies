package id.xyzsystem.budiono.mymovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by budiono on 21/01/18.
 */

//public class MoviesViewHolder {
public class MoviesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.movies_item_image)
    ImageView moviesGambar;

    //private final MoviesCallback callback;
    private static final int moviesLayout = R.layout.view_holder_movies;

    public MoviesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        //this.callback = callback;

        //itemView.setOnClickListener(this);
    }

    //public interface MoviesCallback {
    //    void onWeatherClick(MoviesViewHolder holder);
    //}

    public ImageView getMoviesGambar() {
        return moviesGambar;
    }

}
