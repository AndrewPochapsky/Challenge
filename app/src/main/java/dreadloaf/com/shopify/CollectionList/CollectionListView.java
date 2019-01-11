package dreadloaf.com.shopify.CollectionList;

import java.util.List;

public interface CollectionListView {

    void populateRecyclerView(ShopifyCollections collections);
    void onNetworkFailure();
    void onProductsAcquired(ShopifyProducts products);
}
