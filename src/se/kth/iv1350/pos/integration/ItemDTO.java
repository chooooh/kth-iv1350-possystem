package se.kth.iv1350.pos.integration;

/**
 * This class contains all information about item objects.
 */
public final class ItemDTO {
    private final int itemID;
    private final int itemQuantity;
    private final ItemDescription itemDescription;

    /**
     * Creates a new instance of the itemDTO.
     * @param itemID
     * @param itemQuantity
     * @param itemDescription
     */
    public ItemDTO(int itemID, int itemQuantity, ItemDescription itemDescription) {
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

}
