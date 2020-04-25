package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ItemCatalog {
    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();

    /**
     * Creates an instance. This class holds all item objects.
     */
    ItemCatalog() {
    }

    /**
     * Check if the item list contains the specified <code>itemID</code>, if not, return false else return true
     * @param itemID
     * @return boolean
     */
    public boolean validateItem(int itemID) {
        return itemList.contains(itemID);
    }

    /**
     * Fetches the item with corresponding <code>itemID</code>. The <code>itemQuantity</code> parameter decides the amount.
     * If the desired item isn't found, then return null.
     * @param itemID
     * @param itemQuantity
     * @return ItemDTO
     */
    public ItemDTO fetchItem(int itemID, int itemQuantity) {
        for(ItemDTO item : itemList) {
            if(item.getItemID() == itemID)
                return item;
        }
        return null;
    }

//    private addItems()
}
