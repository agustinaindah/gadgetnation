package id.gadgetnation.app.feature.all_product.detail_product;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;
import id.gadgetnation.app.feature.cart.CartActivity;

public class DetailProductActivity extends BaseActivity {

    @BindView(R.id.sliderDetailProduct)
    SliderLayout sliderDetailProduct;
    @BindView(R.id.txtTitleDetailProduct)
    TextView txtTitleDetailProduct;
    @BindView(R.id.ratingDetailProduct)
    RatingBar ratingDetailProduct;
    /*@BindView(R.id.txtDescDetailProduct)
    TextView txtDescDetailProduct;*/
    @BindView(R.id.btnBuy)
    Button btnBuy;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Title Product");

        displaySlider();
        displayData();
    }

    @Override
    protected int setView() {
        return R.layout.activity_detail_product;
    }

    private void displaySlider() {
        String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";
        HashMap<String, String> file_maps = new HashMap<String, String>();
        file_maps.put("Samsung Note 9", url);
        file_maps.put("Samsung Note 9", url);
        file_maps.put("Samsung Note 9", url);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
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

    private void displayData() {
        txtTitleDetailProduct.setText("Samsung Galaxy A8 Star");
        ratingDetailProduct.setRating(5);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Add to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_cart:
                intent = new Intent(this, CartActivity.class);
                break;
            default:
                break;
        }
        if (intent !=null){
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
