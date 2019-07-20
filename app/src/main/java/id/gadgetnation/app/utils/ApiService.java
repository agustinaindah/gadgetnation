package id.gadgetnation.app.utils;

import id.gadgetnation.app.model.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("kategori_produk")
    Call<BaseResponse> getCategory();

    @GET("produk_by_kategori")
    Call<BaseResponse> getProductByCategory(@Query("cat_id") int id);
}
