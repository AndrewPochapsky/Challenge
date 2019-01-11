package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProducts {
    @SerializedName("products")
    private List<ShopifyProduct> shopifyProducts;

    private long collectionId;

    public List<ShopifyProduct> getProducts() {
        return shopifyProducts;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }
}
