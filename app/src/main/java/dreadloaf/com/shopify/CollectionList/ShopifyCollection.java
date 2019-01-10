package dreadloaf.com.shopify.CollectionList;

import java.util.List;

public class ShopifyCollection {

    private long id;
    private String handle;
    private String title;
    private ShopifyImage image;

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
}
