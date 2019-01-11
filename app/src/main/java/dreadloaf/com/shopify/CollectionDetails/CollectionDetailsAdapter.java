package dreadloaf.com.shopify.CollectionDetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dreadloaf.com.shopify.DownloadImageTask;
import dreadloaf.com.shopify.R;

public class CollectionDetailsAdapter extends RecyclerView.Adapter<CollectionDetailsAdapter.ProductViewHolder>{

    private ProductDetails[] mProductDetails;

    public CollectionDetailsAdapter(ProductDetails[] productDetails){
        mProductDetails = productDetails;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.bind(mProductDetails[i].getName(), mProductDetails[i].getInventory(),
                mProductDetails[i].getCollectionName(), mProductDetails[i].getCollectionImageUrl());
    }

    @Override
    public int getItemCount() {
        return mProductDetails.length;
    }


    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView mProductNameText;
        TextView mInventoryText;
        TextView mCollectionNameText;
        ImageView mCollectionImageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mProductNameText = itemView.findViewById(R.id.product_name);
            mInventoryText = itemView.findViewById(R.id.product_inventory);
            mCollectionNameText = itemView.findViewById(R.id.product_collection_name);
            mCollectionImageView = itemView.findViewById(R.id.product_collection_image);
        }

        void bind(String productName, int inventory, String collectionName, String collectionImageUrl){
            mProductNameText.setText(productName);
            mInventoryText.setText("Inventory: " + String.valueOf(inventory));
            mCollectionNameText.setText(collectionName);
            new DownloadImageTask(mCollectionImageView)
                    .execute(collectionImageUrl);
        }
    }
}
