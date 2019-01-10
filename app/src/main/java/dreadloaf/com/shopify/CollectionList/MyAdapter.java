package dreadloaf.com.shopify.CollectionList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dreadloaf.com.shopify.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CollectionViewHolder>{


    ShopifyCollection[] mCollections;

    public MyAdapter(List<ShopifyCollection> collections){
        //Change to array because I was having an issue before and was messing around
        mCollections = collections.toArray(new ShopifyCollection[collections.size()]);
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collection_list_item, viewGroup, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder collectionViewHolder, int i) {
        collectionViewHolder.bind(mCollections[i].getTitle());
    }

    @Override
    public int getItemCount() {
        return mCollections.length;
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder{

        TextView mNameText;

        public CollectionViewHolder(@NonNull View itemView){
            super(itemView);

            mNameText = itemView.findViewById(R.id.collection_name);
        }

        void bind(String name){
            mNameText.setText(name);
        }

    }
}

