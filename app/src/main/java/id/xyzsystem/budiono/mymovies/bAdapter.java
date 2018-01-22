package id.xyzsystem.budiono.mymovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class bAdapter  extends RecyclerView.Adapter{
    List<bModel> forecasts;

    public bAdapter() {
        forecasts = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(bHolder.ambilLayout(), parent, false);
        return new bHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setWeatherItem((bHolder) holder);
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    private void setWeatherItem(bHolder holder) {
        bModel forecast = forecasts.get(holder.getAdapterPosition());
        //Glide.with(holder.itemView.getContext()).load(ambilMoviesImageUrl(forecast.getPosterPath().ambilGambar())).into(holder.ambilGambar());
        Glide.with(holder.itemView.getContext()).load(ambilMoviesImageUrl(forecast.getPosterPath())).into(holder.ambilGambar());
        //Glide.with(holder.itemView.getContext()).load(ambilMoviesImageUrl(forecast.getPosterPath())).into(holder.ambilGambar());
        //Glide.with(holder.itemView.getContext()).load()

        holder.ambilJudul().setText(forecast.getTitle());
    }

    private String ambilMoviesImageUrl(String moviesPoster) {
        //return "http://openweathermap.org/img/w/" + weatherIcon + ".png";
        return "https://image.tmdb.org/t/p/w500/" + moviesPoster + ".jpg";
    }

    public void kirimData(List<bModel> forecasts) {
        this.forecasts.addAll(forecasts);
        notifyDataSetChanged();
    }
}
