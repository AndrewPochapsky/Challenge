package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProduct {
    private String title;
    private List<ProductVariant> variants;

    private int totalInventory;

    public String getTitle() {
        return title;
    }
    public int getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(int totalInventory) {
        this.totalInventory = totalInventory;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }
}
