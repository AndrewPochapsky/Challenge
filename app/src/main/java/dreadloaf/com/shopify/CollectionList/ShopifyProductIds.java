package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProductIds {
    @SerializedName("collects")
    List<ProductId> productIds;

    private long collectionId;

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }
}
