package id.xyzsystem.budiono.mymovies;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by budiono on 24/01/18.
 */

public class bFunction {
    public static void setImageResource(Context context, String urlImage, ImageView imageView) {
        Glide.with(context)
                .load(urlImage)
                .into(imageView);
    }

    public static String ambilMoviesImageUrl(String moviesPoster) {
        //return "https://image.tmdb.org/t/p/w500/" + moviesPoster + ".jpg";
        return "https://image.tmdb.org/t/p/w185" + moviesPoster;
    }
}
