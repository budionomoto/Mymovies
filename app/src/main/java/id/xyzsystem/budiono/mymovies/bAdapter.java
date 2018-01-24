package id.xyzsystem.budiono.mymovies;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by budiono on 22/01/18.
 */

// on click detail ada disini
    //bentuk pertama, sebelum implement
//public class bAdapter  extends RecyclerView.Adapter {
public class bAdapter  extends RecyclerView.Adapter implements bHolder.MoviesCallback{

    ArrayList<bModel> daftarFilm;
    //ArrayList<bModel> abc;

    public bAdapter() {
        daftarFilm = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(bHolder.ambilLayout(), parent, false);
        return new bHolder(view, this );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        baris((bHolder) holder);
    }

    @Override
    public int getItemCount() {
        return daftarFilm.size();
    }

    private void baris(bHolder holder) {
        //ambil record
        bModel kolom = daftarFilm.get(holder.getAdapterPosition());
        //judul film
        holder.ambilJudul().setText(kolom.getTitle());
        //gambar poster
        bFunction.setImageResource(
                holder.itemView.getContext(),
                bFunction.ambilMoviesImageUrl(kolom.getPosterPath()) ,
                holder.ambilGambar());

        //tanggal
        holder.ambilTanggal().setText(kolom.getTanggal());
        //format tanggal
        //Date tgl = new Date( kolom.getTanggal());
        //SimpleDateFormat outputTgl = new SimpleDateFormat("MMMM dd,yyyy", Locale.getDefault() );
        //String formatTgl = outputTgl.format(tgl);

        //holder.ambilTanggal().setText(formatTgl);
        //http://via.placeholder.com/300.png

        try {
            holder.ambilTanggal().setText(
                    new SimpleDateFormat(
                            "MMMM dd, yyyy", Locale.getDefault()
                    ).format(
                            new SimpleDateFormat(
                                    "yyyy-MM-dd", Locale.getDefault()
                            ).parse(kolom.getTanggal()
                            )
                    )
            );
        }catch (ParseException e){

        }



        //ini dari movies popular
        /*
        Constant.Function.setImageResource(
                holder.itemView.getContext()
                , RetrofitApi.BASE_URL_IMAGE + movies.get(position).getPosterPath()
                , holder.movie_poster);
        */
    }

    public void kirimData(List<bModel> forecasts) {
        this.daftarFilm.clear();
        this.daftarFilm.addAll(forecasts);
        notifyDataSetChanged();
    }

    // baru bisa di implement, ketika holder dibuatkan interface
    @Override
    public void onMoviesClick(bHolder holder) {
        Intent intent = new Intent(holder.itemView.getContext(), Main2Activity.class);
        String positionJson = bAplikasi.ambilInstance().ambilGson().toJson(daftarFilm.get(holder.getAdapterPosition()));
        intent.putExtra("nomerjson", positionJson);
        holder.itemView.getContext().startActivity(intent);
    }
}
