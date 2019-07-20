package id.gadgetnation.app.feature.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseFragment;
import id.gadgetnation.app.feature.all_product.AllProductFragment;

public class AllCategoryFragment extends BaseFragment {

    @BindView(R.id.sliderDetailProduct)
    SliderLayout sliderDetailProduct;

    public static AllCategoryFragment newInstance() {
        Bundle args = new Bundle();
        AllCategoryFragment fragment = new AllCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displaySlider();
        gotoFragmentList();
    }

    @Override
    protected int setView() {
        return R.layout.fragment_all_category;
    }

    private void displaySlider() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Samsung Note 9", R.drawable.slider);
        file_maps.put("Samsung Note 9", R.drawable.slider);
        file_maps.put("Samsung Note 9", R.drawable.slider);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderDetailProduct.addSlider(textSliderView);
        }
        sliderDetailProduct.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderDetailProduct.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderDetailProduct.setCustomAnimation(new DescriptionAnimation());
        sliderDetailProduct.setDuration(5000);

    }

    private void gotoFragmentList() {
       /* getChildFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, AllProductFragment.newInstance())
                .commit();*/
        Fragment childFragment = new AllProductFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, childFragment).commit();

    }
}
