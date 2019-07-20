package id.gadgetnation.app.feature.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseFragment;
import id.gadgetnation.app.model.CatPrototype;

public class CatPrototypeFragment extends BaseFragment {

    @BindView(R.id.layCategory)
    RelativeLayout layCategory;
    @BindView(R.id.rvHorizontal)
    RecyclerView rvHorizontal;

    private List<CatPrototype> catPrototypeList = new ArrayList<>();
    private CatPrototypeAdapter catPrototypeAdapter;

    public static CatPrototypeFragment newInstance() {
        Bundle args = new Bundle();
        CatPrototypeFragment fragment = new CatPrototypeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setView() {
        return R.layout.fragment_category_prototype;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        load();
//        rvHorizontal.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        catPrototypeAdapter = new CatPrototypeAdapter(getActivity(), catPrototypeList);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvHorizontal.setLayoutManager(horizontalLayout);
        rvHorizontal.setAdapter(catPrototypeAdapter);
        categoryList();
    }

/*
    private void load() {
        final FiftyShadesOf fiftyShadesOf = FiftyShadesOf.with(getActivity())
                .on(layCategory)
                .start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fiftyShadesOf.stop();
            }
        }, 3000);
    }
*/

    private void categoryList() {
        /*String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";*/
        CatPrototype catOne = new CatPrototype(getString(R.string.dummy_cat_one),R.drawable.kat_all_kategori);
        CatPrototype catTwo = new CatPrototype(getString(R.string.dummy_cat_two), R.drawable.kat_hp);
        CatPrototype catThree = new CatPrototype(getString(R.string.dummy_cat_three),R.drawable.kat_computer);
        CatPrototype catFour = new CatPrototype(getString(R.string.dummy_cat_four),R.drawable.kat_camera);
        CatPrototype catFive = new CatPrototype(getString(R.string.dummy_cat_five), R.drawable.kat_laptop);

        catPrototypeList.add(catOne);
        catPrototypeList.add(catTwo);
        catPrototypeList.add(catThree);
        catPrototypeList.add(catFour);
        catPrototypeList.add(catFive);
        catPrototypeAdapter.notifyDataSetChanged();
    }

}
