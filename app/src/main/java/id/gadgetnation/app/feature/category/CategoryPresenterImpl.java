package id.gadgetnation.app.feature.category;

import android.content.SharedPreferences;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import id.gadgetnation.app.GadgetNationApp;
import id.gadgetnation.app.model.BaseResponse;
import id.gadgetnation.app.model.Category;
import id.gadgetnation.app.utils.ApiService;
import id.gadgetnation.app.utils.Consts;
import id.gadgetnation.app.utils.Helper;
import id.gadgetnation.app.utils.ServiceInterface;
import retrofit2.Call;
import retrofit2.Response;

public class CategoryPresenterImpl implements CategoryPresenter {

    private View mView;
    private SharedPreferences mPref;

    public CategoryPresenterImpl(View mView) {
        this.mView = mView;
    }

    @Override
    public void getCategory() {
        mPref = GadgetNationApp.getInstance().Prefs();
        final SharedPreferences.Editor edit = mPref.edit();
        String categoriesTemp = mPref.getString(Consts.CATEGORY, null);
        if (categoriesTemp != null){
            JsonArray categories = Helper.parseToJsonArray(categoriesTemp);
            mView.success(parseCategory(categories));
        }
        GadgetNationApp.getInstance().service(new ServiceInterface() {
            @Override
            public Call<BaseResponse> callBackResponse(ApiService apiService) {
                return apiService.getCategory();
            }

            @Override
            public void showProgress() {
                mView.showProgress();
            }

            @Override
            public void hideProgress() {
                try {
                    mView.hideProgress();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void responseSuccess(Response<BaseResponse> response) {
                try {
                    String data = Helper.getGsonInstance().toJson(response.body().getData());
                    JsonObject jsonData = Helper.parseToJsonObject(data);
                    JsonArray jsonRes = jsonData.get("kategori").getAsJsonArray();
                    edit.putString(Consts.CATEGORY, jsonRes.toString()).commit();
                    List<Category> mData = parseCategory(jsonRes);
                    mView.success(mData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseFailed(Response<BaseResponse> response) {
                try {
                    JsonObject jsonRes = Helper.parseToJsonObject(response.errorBody().string());
                    mView.showMessage(jsonRes.get("msgsek").getAsString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable t) {
                mView.notConnect(t.getLocalizedMessage());
            }
        });
    }

    private List<Category> parseCategory(JsonArray categories){
        ArrayList<Category> result = new ArrayList<Category>();

        //main category
        for (JsonElement elCat : categories) {
            JsonObject cat = elCat.getAsJsonObject();
            ArrayList<Category> categorySub = new ArrayList<Category>();

            result.add(new Category(
                    cat.get("term_id").getAsInt(),
                    cat.get("name").getAsString(),
                    cat.get("image").getAsString(),
                    categorySub,
                    Consts.CAT_MAIN
                    /**/
            ));
        }
        return result;
    }
}
