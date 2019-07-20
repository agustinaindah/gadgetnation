package id.gadgetnation.app.feature.category;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import butterknife.BindView;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;

public class MenuCategoryActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.tabsMenuCategory)
    TabLayout tabsMenuCategory;
    @BindView(R.id.vpMenuCategory)
    ViewPager vpMenuCategory;

    private MenuCategoryFragmentAdapter mAdapter;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        initActionBar();

        tabsMenuCategory.setupWithViewPager(vpMenuCategory);
        createViewPager(vpMenuCategory);
        createTabIcons();
    }

    private void createTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Semua Kategori");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kat_all_kategori, 0, 0);
        tabOne.setCompoundDrawablePadding(5);
        tabsMenuCategory.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Smartphone & Aksesoris");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kat_hp, 0, 0);
        tabTwo.setCompoundDrawablePadding(5);
        tabsMenuCategory.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Komputer & Aksesoris");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kat_computer, 0, 0);
        tabThree.setCompoundDrawablePadding(5);
        tabsMenuCategory.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("Camera & Aksesoris");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kat_camera, 0, 0);
        tabFour.setCompoundDrawablePadding(5);
        tabsMenuCategory.getTabAt(3).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFive.setText("Laptop & Aksesoris");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.kat_laptop, 0, 0);
        tabFive.setCompoundDrawablePadding(5);
        tabsMenuCategory.getTabAt(4).setCustomView(tabFive);
    }

    private void createViewPager(ViewPager vpMenuCategory) {
        mAdapter = new MenuCategoryFragmentAdapter(getSupportFragmentManager());

        mAdapter.addFrag(AllCategoryFragment.newInstance(),"Semua Kategori");
        mAdapter.addFrag(AllCategoryFragment.newInstance(),"Semua Kategori");
        mAdapter.addFrag(AllCategoryFragment.newInstance(),"Semua Kategori");
        mAdapter.addFrag(AllCategoryFragment.newInstance(),"Semua Kategori");
        mAdapter.addFrag(AllCategoryFragment.newInstance(),"Semua Kategori");

        vpMenuCategory.setAdapter(mAdapter);
    }

    private void initActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Jelajah");
    }

    @Override
    protected int setView() {
        return R.layout.activity_menu_category;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vpMenuCategory.setCurrentItem(tab.getPosition(), true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
