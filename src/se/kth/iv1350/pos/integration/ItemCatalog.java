package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ItemCatalog {
    private List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

    ItemCatalog() {
    }

    /**
     * Check if the item list contains the specified <code>itemID</code>, if not, return false else return true
     * @param itemID
     * @return
     */
    //fixa denna
    public boolean validateItem(int itemID) {
        return itemDTOList.contains(itemID);
    }
}
