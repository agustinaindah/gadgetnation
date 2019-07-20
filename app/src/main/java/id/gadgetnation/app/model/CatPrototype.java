package id.gadgetnation.app.model;

import android.content.Intent;

public class CatPrototype {
    public Integer productImage;
    public String productName;

    public CatPrototype(String productName, Integer productImage) {
        this.productImage = productImage;
        this.productName = productName;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
