package id.gadgetnation.app.feature.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import id.gadgetnation.app.R;
import id.gadgetnation.app.base.BaseActivity;
import id.gadgetnation.app.feature.checkout.CheckoutActivity;
import id.gadgetnation.app.feature.payment_confirm.PaymentConfirmActivity;
import id.gadgetnation.app.model.CartItem;
import id.gadgetnation.app.utils.Helper;

public class CartActivity extends BaseActivity{

    @BindView(R.id.rvCart)
    RecyclerView rvCart;
    @BindView(R.id.txtTotalHarga)
    TextView txtTotalHarga;
    @BindView(R.id.btnCheckout)
    Button btnCheckout;

    private List<CartItem> cartItemList = new ArrayList<>();
    private CartAdapter cartAdapter;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cart");

        cartAdapter = new CartAdapter(this, cartItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCart.setLayoutManager(linearLayoutManager);
        rvCart.setAdapter(cartAdapter);

        txtTotalHarga.setText("Rp 1.950.000");

        cartProductList();
    }

    @OnClick(R.id.btnCheckout)
    public void checkOut(){
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }

    private void cartProductList() {
        String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";
        CartItem productOne = new CartItem("Samsung Galaxy A8 Star", url, "Rp 3900000");
        CartItem productTwo = new CartItem("Samsung Galaxy A8 Star", url, "Rp 3900000");

        cartItemList.add(productOne);
        cartItemList.add(productTwo);
        cartAdapter.notifyDataSetChanged();
    }

    @Override
    protected int setView() {
        return R.layout.activity_cart;
    }
}
