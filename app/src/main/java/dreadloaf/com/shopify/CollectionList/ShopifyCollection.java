package dreadloaf.com.shopify.CollectionList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopifyCollection {

    private long id;
    private String handle;
    private String title;
    private ShopifyImage image;
    @SerializedName("body_html")
    private String description;

    public long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getTitle() {
        return title;
    }

    public ShopifyImage getimage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
