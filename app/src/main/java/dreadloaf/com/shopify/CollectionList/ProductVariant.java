package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

public class ProductVariant {

    @SerializedName("inventory_quantity")
    private int inventory;

    public int getInventory() {
        return inventory;
    }
}
