package dreadloaf.com.shopify.CollectionList;

public interface CollectionListView {

    void populateRecyclerView(ShopifyCollections collections);
    void onNetworkFailure();
    void onProductsAcquired(ShopifyProducts products);
}
