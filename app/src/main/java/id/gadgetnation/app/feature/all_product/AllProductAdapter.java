package id.gadgetnation.app.feature.all_product;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gadgetnation.app.R;
import id.gadgetnation.app.feature.all_product.detail_product.DetailProductActivity;
import id.gadgetnation.app.model.AllProduct;
import id.gadgetnation.app.utils.Helper;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.ViewHolder>{

    private Context context;
    private List<AllProduct> allProducts;

    public AllProductAdapter(Context context, List<AllProduct> allProducts) {
        this.context = context;
        this.allProducts = allProducts;
    }

    @Override
    public AllProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_simple_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllProductAdapter.ViewHolder holder, int position) {
        final AllProduct allProduct = (AllProduct) allProducts.get(position);

        Helper.displayImage(context, allProduct.getProductImage(), holder.imgSimpleCard);
        holder.txtTitleSimpleCard.setText(allProduct.getProductName());
        holder.txtPriceSimpleCard.setText(allProduct.getProductPrice());

        holder.cardSimpleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardSimpleCard)
        CardView cardSimpleCard;
        @BindView(R.id.imgSimpleCard)
        ImageView imgSimpleCard;
        @BindView(R.id.txtTitleSimpleCard)
        TextView txtTitleSimpleCard;
        @BindView(R.id.txtPriceSimpleCard)
        TextView txtPriceSimpleCard;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
