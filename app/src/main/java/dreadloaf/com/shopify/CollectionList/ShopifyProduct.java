package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProduct {
    private String title;
    private List<ProductVariant> variants;

    public String getTitle() {
        return title;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }
}
