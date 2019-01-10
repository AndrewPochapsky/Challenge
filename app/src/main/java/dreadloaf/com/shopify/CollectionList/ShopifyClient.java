package dreadloaf.com.shopify.CollectionList;

import java.util.List;

import retrofit2.http.GET;

public interface ShopifyClient {

    @GET("/admin/custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    List<Collection> getCollections();

}
