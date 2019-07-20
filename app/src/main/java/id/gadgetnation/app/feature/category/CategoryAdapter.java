package id.gadgetnation.app.feature.category;

import android.content.Context;
import android.content.Intent;
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
import id.gadgetnation.app.model.Category;
import id.gadgetnation.app.utils.Consts;
import id.gadgetnation.app.utils.Helper;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private Context context;
    private List<Category> categories;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void updateData(List<Category> categories){
        this.categories = categories;
        notifyDataSetChanged();
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        final Category category = (Category) categories.get(position);

        holder.txtCategoryTitle.setText(category.getCategoryTitle());
        Helper.displayImage(context, category.getCategoryImage(), holder.imgCategorySub);
        holder.imgCategorySub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductByCategory(category);
            }
        });

        holder.layItemSimpleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductByCategory(category);
            }
        });
    }

    private void gotoProductByCategory(Category category) {
        /*Intent intent = new Intent(context, ProductByCategoryActivity.class);
        intent.putExtra(Consts.ARG_DATA, category);
        context.startActivity(intent);*/
    }

    private boolean isHaveCategorySub(Category category) {
        return category.getCategorySub().size() == 0;
    }

    @Override
    public int getItemCount() {
        return categories.size();
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
