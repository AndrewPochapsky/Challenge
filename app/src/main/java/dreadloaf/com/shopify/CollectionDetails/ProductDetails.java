package dreadloaf.com.shopify.CollectionDetails;

public class ProductDetails {
    private String name;
    private int inventory;
    private String collectionName;
    private String collectionImageUrl;

    public ProductDetails(String name, int inventory, String collectionName, String collectionImageUrl){
        this.name = name;
        this.inventory = inventory;
        this.collectionName = collectionName;
        this.collectionImageUrl = collectionImageUrl;
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
        return inventory;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getCollectionImageUrl() {
        return collectionImageUrl;
    }




}
