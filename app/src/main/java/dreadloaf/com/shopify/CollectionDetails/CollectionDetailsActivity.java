package dreadloaf.com.shopify.CollectionDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dreadloaf.com.shopify.DownloadImageTask;
import dreadloaf.com.shopify.R;

public class CollectionDetailsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private TextView mTitleText;
    private TextView mDescriptionText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mImageView = findViewById(R.id.header_image);
        mTitleText = findViewById(R.id.header_title);
        mDescriptionText = findViewById(R.id.header_description);

        mRecyclerView = findViewById(R.id.recycler_view_product_details);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        Intent previousActivityIntent = getIntent();

        String[] productNames = previousActivityIntent.getStringArrayExtra("productNames");
        int[] productInventories = previousActivityIntent.getIntArrayExtra("productInventories");
        String collectionName = previousActivityIntent.getStringExtra("collectionName");
        String imageUrl = previousActivityIntent.getStringExtra("collectionImageUrl");
        String collectionDescription = previousActivityIntent.getStringExtra("collectionDescription");

        mTitleText.setText(collectionName);
        if(!collectionDescription.isEmpty()){
            mDescriptionText.setText(collectionDescription);
        }else{
            mDescriptionText.setVisibility(View.GONE);
        }

        new DownloadImageTask(mImageView)
                .execute(imageUrl);

        ProductDetails[] productDetails = new ProductDetails[productNames.length];
        for(int i = 0; i < productNames.length; i++){
            productDetails[i] = new ProductDetails(productNames[i], productInventories[i], collectionName, imageUrl);
        }

        mRecyclerView.setAdapter(new CollectionDetailsAdapter(productDetails));
    }
}
