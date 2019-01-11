package dreadloaf.com.shopify.CollectionDetails;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import dreadloaf.com.shopify.R;

public class CollectionDetailsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mRecyclerView = findViewById(R.id.recycler_view_product_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        Intent previousActivityIntent = getIntent();

        String[] productNames = previousActivityIntent.getStringArrayExtra("productNames");
        int[] productInventories = previousActivityIntent.getIntArrayExtra("productInventories");
        String collectionName = previousActivityIntent.getStringExtra("collectionName");
        String imageUrl = previousActivityIntent.getStringExtra("collectionImageUrl");

        ProductDetails[] productDetails = new ProductDetails[productNames.length];
        for(int i = 0; i < productNames.length; i++){
            productDetails[i] = new ProductDetails(productNames[i], productInventories[i], collectionName, imageUrl);
        }
        Log.e("CDA", String.valueOf(productDetails.length));
        mRecyclerView.setAdapter(new CollectionDetailsAdapter(productDetails));
    }
}
