package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProducts {
    @SerializedName("products")
    private List<ShopifyProduct> shopifyProducts;

    public List<ShopifyProduct> getProducts() {
        return shopifyProducts;
    }
}
