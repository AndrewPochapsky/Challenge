package dreadloaf.com.shopify.CollectionList;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CollectionListInteractor {

    public interface OnCompleteListener{
        void onSuccessCollection(ShopifyCollections collections);
        void onSuccessProductIds(ShopifyProductIds productIds);
        void onSuccessProducts(ShopifyProducts products);
        void onFailureCollection();
    }

    public void getCollectionsResponse(String url, final OnCompleteListener listener){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

                String json = response.body().string();

                Gson gson = new Gson();
                final ShopifyCollections collections = gson.fromJson(json, ShopifyCollections.class);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("THing", String.valueOf(collections.collections.size()));
                        listener.onSuccessCollection(collections);
                    }
                });
            }
        });
    }

    public void getProductIds(long collectionId, final OnCompleteListener listener){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://shopicruit.myshopify.com/admin/collects.json?collection_id=" + String.valueOf(collectionId) +"&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
                Log.e("Interactor", "Error in product ids");
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                ShopifyProductIds shopifyProductIds = gson.fromJson(json, ShopifyProductIds.class);
                listener.onSuccessProductIds(shopifyProductIds);
            }
        });
    }

    public void getProducts(List<ProductId> productIds, final OnCompleteListener listener){
        StringBuilder ids = new StringBuilder();
        for(ProductId productId : productIds){
            ids.append(String.valueOf(productId.getId())).append(',');
        }
        //Log.e("Id String", ids.toString());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://shopicruit.myshopify.com/admin/products.json?ids="
                        + ids.toString()+
                        "&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                //Log.e("Int", json);
                ShopifyProducts shopifyProducts = gson.fromJson(json, ShopifyProducts.class);
                listener.onSuccessProducts(shopifyProducts);
            }
        });
    }

}
