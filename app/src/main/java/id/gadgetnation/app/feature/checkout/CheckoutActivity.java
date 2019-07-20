package id.gadgetnation.app.feature.checkout;

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
import id.gadgetnation.app.feature.payment_confirm.PaymentConfirmActivity;
import id.gadgetnation.app.model.CartItem;
import id.gadgetnation.app.utils.Helper;

public class CheckoutActivity extends BaseActivity {

    @BindView(R.id.rvCheckout)
    RecyclerView rvCheckout;
    @BindView(R.id.txtTotalHarga)
    TextView txtTotalHarga;
    @BindView(R.id.btnBuyNow)
    Button btnBuyNow;

    private List<CartItem> cartItems = new ArrayList<>();
    private CheckoutAdapter checkoutAdapter;

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Checkout");

        checkoutAdapter = new CheckoutAdapter(this, cartItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCheckout.setLayoutManager(linearLayoutManager);
        rvCheckout.setAdapter(checkoutAdapter);

        txtTotalHarga.setText("Rp 1.950.000");

        checkoutList();
    }

    @OnClick(R.id.btnBuyNow)
    public void buyNow(){
        Intent intent = new Intent(this, PaymentConfirmActivity.class);
        startActivity(intent);
    }

    private void checkoutList() {
        String url = "https://images.samsung.com/is/image/samsung/id-galaxy-a8-star-g885-sm-g885fzkdxid-frontblack-thumb-107037771?$PF_PRD_PNG$";
        CartItem productOne = new CartItem("Samsung Galaxy A8 Star", url, "Rp 3900000");
        CartItem productTwo = new CartItem("Samsung Galaxy A8 Star", url, "Rp 3900000");

        cartItems.add(productOne);
        cartItems.add(productTwo);
        checkoutAdapter.notifyDataSetChanged();
    }

    @Override
    protected int setView() {
        return R.layout.activity_checkout;
    }
}
