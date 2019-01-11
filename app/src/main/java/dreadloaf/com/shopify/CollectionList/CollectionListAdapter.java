package dreadloaf.com.shopify.CollectionList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dreadloaf.com.shopify.DownloadImageTask;
import dreadloaf.com.shopify.R;

public class CollectionListAdapter extends RecyclerView.Adapter<CollectionListAdapter.CollectionViewHolder>{

    public interface OnCollectionClickedListener{
        void onClick(int index);
    }


    private ShopifyCollection[] mCollections;
    private OnCollectionClickedListener mListener;

    public CollectionListAdapter(List<ShopifyCollection> collections, OnCollectionClickedListener listener){
        //Converted to array because I was having an issue before and was trying different things to fix it
        mCollections = collections.toArray(new ShopifyCollection[collections.size()]);
        mListener = listener;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collection_list_item, viewGroup, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder collectionViewHolder, int i) {
        collectionViewHolder.bind(mCollections[i].getTitle(), i, mCollections[i].getimage().getSource());
    }

    @Override
    public int getItemCount() {
        return mCollections.length;
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mNameText;
        private ImageView mImageView;
        private int index;


        public CollectionViewHolder(@NonNull View itemView){
            super(itemView);

            mNameText = itemView.findViewById(R.id.collection_name);
            mImageView = itemView.findViewById(R.id.collection_list_image);
            itemView.setOnClickListener(this);
        }

        void bind(String name, int index, String imageUrl){
            mNameText.setText(name);
            this.index = index;
            new DownloadImageTask(mImageView)
                    .execute(imageUrl);
        }

        @Override
        public void onClick(View view) {
           mListener.onClick(index);
        }
    }
}

