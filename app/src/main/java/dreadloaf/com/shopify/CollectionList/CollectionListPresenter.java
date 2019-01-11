package dreadloaf.com.shopify.CollectionList;

import android.util.Log;

import java.util.List;

public class CollectionListPresenter implements CollectionListInteractor.OnCompleteListener {
    private CollectionListView mView;
    private CollectionListInteractor mInteractor;

    public CollectionListPresenter(CollectionListView view, CollectionListInteractor interactor){
        mView = view;
        mInteractor = interactor;
    }

    public void getCollections(){
        mInteractor.getCollectionsResponse("https://shopicruit.myshopify.com/admin/custom_collections.json?access_token=c32313df0d0ef512ca64d5b336a0d7c6", this);
    }

    public void getProducts(long collectionId){
        mInteractor.getProductIds(collectionId, this);
    }

    @Override
    public void onSuccessCollection(ShopifyCollections collections) {
        if(mView != null){
            mView.populateRecyclerView(collections);
        }else{
            Log.e("pres", "is null");
        }
    }

    @Override
    public void onSuccessProductIds(ShopifyProductIds productIds) {
        //now it is time to get the products themselves
        mInteractor.getProducts(productIds.productIds, this);
    }

    @Override
    public void onSuccessProducts(ShopifyProducts products) {
        if(mView != null){
            mView.onProductsAcquired(products);
        }
    }

    @Override
    public void onFailureCollection() {
        if(mView != null){
            mView.onNetworkFailure();
        }
    }
}
