package dreadloaf.com.shopify.CollectionList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dreadloaf.com.shopify.CollectionDetails.CollectionDetailsActivity;
import dreadloaf.com.shopify.R;

public class CollectionListActivity extends AppCompatActivity implements CollectionListView, CollectionListAdapter.OnCollectionClickedListener {

    private CollectionListPresenter mPresenter;

    private RecyclerView mRecyclerView;

    private List<ShopifyCollection> mCollections;
    private List<ShopifyProducts> mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProducts = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mPresenter = new CollectionListPresenter(this, new CollectionListInteractor());
        mPresenter.getCollections();
    }

    @Override
    public void populateRecyclerView(ShopifyCollections collections) {
        mCollections = collections.collections;
        mRecyclerView.setAdapter(new CollectionListAdapter(collections.collections, this));

        for(ShopifyCollection col : collections.collections){
            mPresenter.getProducts(col.getId());
        }
    }

    @Override
    public void onNetworkFailure() {
        Toast.makeText(this, "Error retrieving data.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProductsAcquired(ShopifyProducts products) {
        mProducts.add(products);
    }

    @Override
    public void onClick(int index) {
        Intent intent = new Intent(this, CollectionDetailsActivity.class);

        ShopifyCollection collection = mCollections.get(index);
        ShopifyProducts products = null;
        for(ShopifyProducts shopifyProducts : mProducts){
            if(shopifyProducts.getCollectionId() == collection.getId()){
                products = shopifyProducts;
                break;
            }
        }
        if(products != null){
            String[] productNames = new String[products.getProducts().size()];
            int[] productInventories = new int[products.getProducts().size()];
            for(int i = 0; i < productNames.length; i++){
                ShopifyProduct currentProduct = products.getProducts().get(i);
                int totalInventory = 0;
                for(ProductVariant variant : currentProduct.getVariants()){
                    totalInventory += variant.getInventory();
                }
                productNames[i] = currentProduct.getTitle();
                productInventories[i] = totalInventory;
            }

            intent.putExtra("productNames", productNames);
            intent.putExtra("productInventories", productInventories);
            intent.putExtra("collectionName", collection.getTitle());
            intent.putExtra("collectionImageUrl", collection.getimage().getSource());
            intent.putExtra("collectionDescription", collection.getDescription());
            startActivity(intent);
        }else{
            Toast.makeText(this, "Please try again in a second", Toast.LENGTH_SHORT).show();
        }

    }
}
