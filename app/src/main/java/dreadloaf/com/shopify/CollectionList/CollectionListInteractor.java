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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CollectionListInteractor {

    public interface OnCompleteListener{
        void onSuccessCollection(ShopifyCollections collections);
        void onFailureCollection();
    }
    ShopifyCollections mMainCollection;
    public void getJsonResponse(String url, final OnCompleteListener listener){
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
                mMainCollection = gson.fromJson(json, ShopifyCollections.class);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("THing", String.valueOf(mMainCollection.collections.size()));
                        listener.onSuccessCollection(mMainCollection);
                    }
                });


            }
        });
        if(mMainCollection != null){
            Log.e("Y", "Not Null");
        }else{
            Log.e("Y", "Null");
        }

    }
}
