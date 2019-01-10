package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

public class ShopifyImage {
    @SerializedName("src")
    private String source;

    public String getSource() {
        return source;
    }
}
