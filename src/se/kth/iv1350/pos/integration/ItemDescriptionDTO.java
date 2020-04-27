package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.Objects;

/**
 * This class represents the description of an item.
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

    @Override
    public String toString() {
        return "ItemDescriptionDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemVAT=" + itemVAT +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemDescriptionDTO other = (ItemDescriptionDTO) obj;
        return Objects.equals(itemName, other.itemName) &&
                Objects.equals(itemPrice, other.itemPrice) &&
                Objects.equals(itemVAT, other.itemVAT);
    }

}
