package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

/**
 * This class describes <code>ItemDTO</code> objects.
 */
public class ItemDescriptionDTO {
    private String itemName;
    private Amount itemPrice;
    private Amount itemVAT;

    /**
     * Creates a new instance, and will be used in the <code>ItemDTO</code> objects.
     * @param itemName
     * @param itemPrice
     * @param itemVAT
     */
    public ItemDescriptionDTO(String itemName, Amount itemPrice, Amount itemVAT) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemVAT = itemVAT;
    }

    public String getItemName() {
        return itemName;
    }

    public Amount getItemPrice() {
        return itemPrice;
    }

    public Amount getItemVAT() {
        return itemVAT;
    }

    public String toString() {
        return itemName + "price: " + String.valueOf(itemPrice) + " VAT: " + String.valueOf(itemVAT);
    }
}
