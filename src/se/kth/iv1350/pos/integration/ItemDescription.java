package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

/**
 * This class describes <code>ItemDTO</code> objects.
 */
public class ItemDescription {
    private Amount itemPrice;
    private String itemName;
    private Amount itemVAT;

    /**
     * Creates a new instance, and will be used in the <code>ItemDTO</code> objects.
     * @param itemPrice
     * @param itemName
     * @param itemVAT
     */
    public ItemDescription(Amount itemPrice, String itemName, Amount itemVAT) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemVAT = itemVAT;
    }

}
