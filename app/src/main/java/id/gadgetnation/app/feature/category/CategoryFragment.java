package id.gadgetnation.app.feature.category;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.florent37.fiftyshadesof.FiftyShadesOf;

import java.util.List;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseFragment;
import id.gadgetnation.app.feature.MainActivity;
import id.gadgetnation.app.model.Category;
import id.gadgetnation.app.utils.Consts;
import id.gadgetnation.app.utils.Helper;

public class CategoryFragment extends BaseFragment implements CategoryPresenter.View{

    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    private CategoryPresenter mPresenter;
    private String mType;
    private FiftyShadesOf fiftyShadesOf;

    public static CategoryFragment newInstance(String type, Category category) {
        Bundle args = new Bundle();
        args.putString(Consts.ARG_TYPE, type);
        args.putSerializable(Consts.ARG_DATA, category);
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setView() {
        return R.layout.fragment_categories;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null){
            mPresenter = new CategoryPresenterImpl(this);
            Bundle args = getArguments();
            if (args !=null){
                mType = args.getString(Consts.ARG_TYPE);
                if (mType.equals(Consts.CAT_MAIN)){
                    mPresenter.getCategory();
                } else {
                    Category cat = (Category) args.getSerializable(Consts.ARG_DATA);
                    CategoryAdapter adapter = new CategoryAdapter(getActivity());
                    adapter.updateData(cat.getCategorySub());
                    rvCategories.setAdapter(adapter);
                    /*if (layProgress.isShown()){
                        layProgress.setVisibility(View.GONE);
                    }*/
                }
            }
            setupRecyclerView();
        }
    }

    private void setupRecyclerView() {
        rvCategories.setHasFixedSize(true);
        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvCategories.setNestedScrollingEnabled(false);
    }

    @Override
    public void success(List<Category> categories) {
        CategoryAdapter adapter = new CategoryAdapter(getActivity());
        adapter.updateData(categories);
        rvCategories.setAdapter(adapter);
    }

    /* final FiftyShadesOf fiftyShadesOf = FiftyShadesOf.with(this)
            .on(R.id.layout, R.id.layout1, R.id.layout2)
            .start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fiftyShadesOf.stop();
            }
        }, 2000);
    }*/

    @Override
    public void showProgress() {
        fiftyShadesOf = FiftyShadesOf.with(getActivity())
                .on(rvCategories)
                .start();
    }

    @Override
    public void hideProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fiftyShadesOf.stop();
            }
        }, 2000);
    }

    @Override
    public void showMessage(String msg) {
        Helper.createAlert(getActivity(), "Info", msg);
    }

    @Override
    public void notConnect(String msg) {
        Helper.createAlert(getActivity(), "Info", msg);
    }
}
