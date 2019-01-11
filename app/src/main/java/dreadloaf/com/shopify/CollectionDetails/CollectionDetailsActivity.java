package dreadloaf.com.shopify.CollectionDetails;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dreadloaf.com.shopify.R;

public class CollectionDetailsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent previousActivityIntent = getIntent();

        String[] productNames = previousActivityIntent.getStringArrayExtra("productNames");
        int[] productInventories = previousActivityIntent.getIntArrayExtra("productInventories");
        String collectionName = previousActivityIntent.getStringExtra("collectionName");
        String imageUrl = previousActivityIntent.getStringExtra("collectionImageUrl");



    }
}
