package id.gadgetnation.app.feature.category;

import java.util.List;

import id.gadgetnation.app.base.BaseView;
import id.gadgetnation.app.model.Category;

public interface CategoryPresenter {

    interface View extends BaseView{
        void success(List<Category> categories);
    }

    void getCategory();
}
