package id.gadgetnation.app.feature;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;
import id.gadgetnation.app.feature.all_product.AllProductFragment;
import id.gadgetnation.app.feature.cart.CartActivity;
import id.gadgetnation.app.feature.category.CatPrototypeFragment;
import id.gadgetnation.app.feature.category.CategoryFragment;
import id.gadgetnation.app.feature.category.MenuCategoryActivity;
import id.gadgetnation.app.feature.search.SearchFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.sliderBannerHome)
    SliderLayout sliderBannerHome;

    private Fragment mFragment = null;
    private FragmentManager fm;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        fm = getSupportFragmentManager();
        setSupportActionBar(toolbar);
        setupActionBarDrawer();
        setupNavigationView();
        setupBanner();
        navigationView.setNavigationItemSelectedListener(this);
        collapsingToolbar.setTitle("");
        gotoFeature();

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Gagdet Nation");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

    }

    private void gotoFeature() {
        /*FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragmentContainer, CatPrototypeFragment.newInstance());
        ft.add(R.id.fragmentContainer2, AllProductFragment.newInstance());
        ft.commit();*/
        gotoFragment(fm, SearchFragment.newInstance());
    }

    private void setupBanner() {
        /*String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";*/
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Samsung Note 9", R.drawable.slider);
        file_maps.put("Samsung Note 9", R.drawable.slider);
        file_maps.put("Samsung Note 9", R.drawable.slider);

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

            sliderBannerHome.addSlider(textSliderView);
        }
        sliderBannerHome.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderBannerHome.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderBannerHome.setCustomAnimation(new DescriptionAnimation());
        sliderBannerHome.setDuration(5000);
    }

    @Override
    protected void onStop() {
        sliderBannerHome.startAutoCycle();
        super.onStop();
    }

    private void setupNavigationView() {
        Menu navMenu = navigationView.getMenu();
        navMenu.setGroupVisible(R.id.nav_menu_before_login, true);
        navMenu.setGroupVisible(R.id.nav_menu_after_login, false);

        View header = navigationView.getHeaderView(0);
        LinearLayout headBeforeLogin = ButterKnife.findById(header, R.id.headBeforeLogin);

        if (true){
            headBeforeLogin.setVisibility(View.VISIBLE);
        } else {
            headBeforeLogin.setVisibility(View.GONE);
        }
    }


    private void setupActionBarDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setupNavigationView();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_category:
                intent = new Intent(this, MenuCategoryActivity.class);
                break;
            case R.id.nav_login:
                break;
        }
        if (intent != null){
            startActivity(intent);

        } if (mFragment !=null){
            gotoFragment(fm, mFragment, true);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_wishlist:
                break;
            case R.id.action_cart:
                intent = new Intent(this, CartActivity.class);
                break;
            default:
                break;
        }
        if (intent != null){
            startActivity(intent);

        } if (mFragment != null){
            gotoFragment(fm, mFragment, true);
        }

        return super.onOptionsItemSelected(item);
    }
}
