package dreadloaf.com.shopify.CollectionList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dreadloaf.com.shopify.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CollectionViewHolder>{


    List<ShopifyCollection> mCollections;

    public MyAdapter(List<ShopifyCollection> collections){
        mCollections = collections;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collection_list_item, viewGroup, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder collectionViewHolder, int i) {
        
    }

    @Override
    public int getItemCount() {
        return mCollections.size();
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder{

        public CollectionViewHolder(@NonNull View itemView){
            super(itemView);

        }

    }
}

