package id.gadgetnation.app.feature.cart;

import android.content.Context;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    private Context context;
    private List<CartItem> cartItems;

    public CartAdapter(Context context, List<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {
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
