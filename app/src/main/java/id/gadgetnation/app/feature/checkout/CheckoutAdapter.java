package id.gadgetnation.app.feature.checkout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gadgetnation.app.R;
import id.gadgetnation.app.model.CartItem;
import id.gadgetnation.app.utils.Helper;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    private Context context;
    private List<CartItem> cartItems;

    public CheckoutAdapter(Context context, List<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CheckoutAdapter.ViewHolder holder, int position) {
        final CartItem cartItem = (CartItem) cartItems.get(position);

        Helper.displayImage(context, cartItem.getProductImage(), holder.imgProductCart);
        holder.txtProductTitle.setText(cartItem.getProductName());
        holder.txtProductPrice.setText(cartItem.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgProductCart)
        ImageView imgProductCart;
        @BindView(R.id.txtProductTitle)
        TextView txtProductTitle;
        @BindView(R.id.txtProductPrice)
        TextView txtProductPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
