package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

public class ProductId {
    @SerializedName("product_id")
    private long id;

    public long getId() {
        return id;
    }
}
