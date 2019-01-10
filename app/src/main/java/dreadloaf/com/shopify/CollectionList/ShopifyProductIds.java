package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyProductIds {
    @SerializedName("collects")
    List<ProductId> productIds;
}
