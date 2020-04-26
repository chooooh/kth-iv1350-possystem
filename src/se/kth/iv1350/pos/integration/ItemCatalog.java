package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ItemCatalog {
    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();
    private final Amount VAT_TWENTY_FIVE = new Amount(1.25);
    private final Amount VAT_TWELVE = new Amount(1.12);
    private final Amount VAT_FIVE = new Amount(1.05);

    /**
     * Creates an instance. This class holds all item objects. The method @link
     */
    ItemCatalog() {
        addItems();
    }

    /**
     * Check if the item list contains the specified <code>itemID</code>, if not, return false else return true
     * @param itemID
     * @return boolean
     */
    public boolean validateItem(int itemID) {
        for(ItemDTO item : itemList) {
            if(item.getItemID() == itemID)
                return true;
        }
        return false;
    }

    /**
     * Fetches the item with corresponding <code>itemID</code>. The <code>itemQuantity</code> parameter decides the amount.
     * If the desired item isn't found, then return null.
     * @param itemID
     * @return <ItemDTO, Integer> return a hashmap
     */
    public ItemDTO fetchItem(int itemID) {
        for(ItemDTO item : itemList) {
            if(item.getItemID() == itemID)
                return item;
        }
        return null;
    }

    private void addItems() {
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), VAT_TWENTY_FIVE);
        ItemDescriptionDTO milkDescription = new ItemDescriptionDTO("Milk", new Amount(20), VAT_TWELVE);
        ItemDescriptionDTO SpinachDescription = new ItemDescriptionDTO("Spinach", new Amount(30), VAT_TWELVE);

        itemList.add(new ItemDTO(1, appleDescription));
        itemList.add(new ItemDTO(2, milkDescription));
        itemList.add(new ItemDTO(3, SpinachDescription));

    }
}
