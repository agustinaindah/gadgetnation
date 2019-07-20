package id.gadgetnation.app.feature.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gadgetnation.app.R;
import id.gadgetnation.app.model.CatPrototype;
import id.gadgetnation.app.utils.Helper;

public class CatPrototypeAdapter extends RecyclerView.Adapter<CatPrototypeAdapter.ViewHolder>{

    private Context context;
    private List<CatPrototype> catPrototypes;

    public CatPrototypeAdapter(Context context, List<CatPrototype> catPrototypes) {
        this.context = context;
        this.catPrototypes = catPrototypes;
    }

    @Override
    public CatPrototypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CatPrototypeAdapter.ViewHolder holder, int position) {
        final CatPrototype catPrototype = (CatPrototype) catPrototypes.get(position);

        holder.txtCategoryTitle.setText(catPrototype.getProductName());
        /*Helper.displayImage(context, catPrototype.getProductImage(), holder.imgCategorySub);*/
        holder.imgCategorySub.setImageResource(catPrototype.getProductImage());
        holder.imgCategorySub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductByCategory(catPrototype);
            }
        });

        holder.layItemSimpleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductByCategory(catPrototype);
            }
        });
    }

    private void gotoProductByCategory(CatPrototype catPrototype) {
        /*Intent intent = new Intent(context, ProductByCategoryActivity.class);
        intent.putExtra(Consts.ARG_DATA, category);
        context.startActivity(intent);*/
    }

    @Override
    public int getItemCount() {
        return catPrototypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.layItemSimpleCard)
        RelativeLayout layItemSimpleCard;
        @BindView(R.id.imgCategorySub)
        ImageView imgCategorySub;
        @BindView(R.id.txtCategoryTitle)
        TextView txtCategoryTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
