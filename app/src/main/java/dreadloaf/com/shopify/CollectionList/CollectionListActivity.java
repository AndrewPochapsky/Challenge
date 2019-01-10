package dreadloaf.com.shopify.CollectionList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import dreadloaf.com.shopify.R;

public class CollectionListActivity extends AppCompatActivity implements CollectionListView {

    private CollectionListPresenter mPresenter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mPresenter = new CollectionListPresenter(this, new CollectionListInteractor());
        mPresenter.getCollections();

    }

    @Override
    public void populateRecyclerView(ShopifyCollections collections) {
        mRecyclerView.setAdapter(new MyAdapter(collections.collections, this, this, mRecyclerView));
    }

    @Override
    public void onNetworkFailure() {

    }
}
