package id.gadgetnation.app.feature.all_product;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseFragment;
import id.gadgetnation.app.model.AllProduct;
import id.gadgetnation.app.model.CatPrototype;

public class AllProductFragment extends BaseFragment {

    @BindView(R.id.rvListProduct)
    RecyclerView rvListProduct;

    private List<AllProduct> allProductList = new ArrayList<>();
    private AllProductAdapter allProductAdapter;

    public static AllProductFragment newInstance() {
        Bundle args = new Bundle();
        AllProductFragment fragment = new AllProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setView() {
        return R.layout.fragment_list_product;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        rvListProduct.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        allProductAdapter = new AllProductAdapter(getActivity(), allProductList);
        GridLayoutManager verticalLayout = new GridLayoutManager(getActivity(), 2);
        rvListProduct.setLayoutManager(verticalLayout);
        rvListProduct.setAdapter(allProductAdapter);
        allProductList();
    }

    private void allProductList() {
        String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";
        AllProduct productOne = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");
        AllProduct productTwo = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");
        AllProduct productThree = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");
        AllProduct productFour = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");
        AllProduct productFive = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");
        AllProduct productSix = new AllProduct("Samsung Galaxy A8 Star", url, "Rp 3900000");

        allProductList.add(productOne);
        allProductList.add(productTwo);
        allProductList.add(productThree);
        allProductList.add(productFour);
        allProductList.add(productFive);
        allProductList.add(productSix);
        allProductAdapter.notifyDataSetChanged();
    }
}
