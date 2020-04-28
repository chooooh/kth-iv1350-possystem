package se.kth.iv1350.pos.model;

/**
 * This class represents the retail store of the sale.
 */
public class RetailStore {
    private String storeName;
    private String storeAddress;

    public RetailStore(String storeName, String storeAddress) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }
}
