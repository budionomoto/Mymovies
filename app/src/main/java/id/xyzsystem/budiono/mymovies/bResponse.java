package id.xyzsystem.budiono.mymovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by budiono on 22/01/18.
 */

public class bResponse {
    //ambil semua
    @SerializedName("results")
    private List<bModel> modelList;

    public List<bModel> ambilmodelList() {
        return modelList;
    }
}
