package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyCollections {
    @SerializedName("custom_collections")
    List<ShopifyCollection> collections;
}
