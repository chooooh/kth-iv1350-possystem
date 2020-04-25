package se.kth.iv1350.pos.integration;

/**
 * This class contains all information about item objects.
 */
public class ItemDTO {
    private int itemQuantity;
    private final int itemID;
    private final ItemDescriptionDTO itemDescriptionDTO;

    /**
     * Creates a new instance of the itemDTO.
     * @param itemID
     * @param itemQuantity
     * @param itemDescriptionDTO
     */
    public ItemDTO(int itemID, int itemQuantity, ItemDescriptionDTO itemDescriptionDTO) {
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemDescriptionDTO = itemDescriptionDTO;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public ItemDescriptionDTO getItemDescriptionDTO() {
        return itemDescriptionDTO;
    }



}
