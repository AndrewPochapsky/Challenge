package dreadloaf.com.shopify.CollectionList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import dreadloaf.com.shopify.R;

public class CollectionListActivity extends AppCompatActivity implements CollectionListView {

    private CollectionListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new CollectionListPresenter(this, new CollectionListInteractor());
        mPresenter.getCollections();
    }

    @Override
    public void populateRecyclerView(List<ShopifyCollection> collections) {
        for(ShopifyCollection col : collections){
            Log.e("Main", col.getTitle());
        }
    }

    @Override
    public void onNetworkFailure() {

    }
}
