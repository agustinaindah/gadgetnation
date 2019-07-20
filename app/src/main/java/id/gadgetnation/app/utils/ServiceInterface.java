package id.gadgetnation.app.utils;

import id.gadgetnation.app.model.BaseResponse;
import retrofit2.Call;
import retrofit2.Response;

public interface ServiceInterface {

    Call<BaseResponse> callBackResponse(ApiService apiService);

    void showProgress();

    void hideProgress();

    void responseSuccess(Response<BaseResponse> response);

    void responseFailed(Response<BaseResponse> response);

    void failed(Throwable t);

}
