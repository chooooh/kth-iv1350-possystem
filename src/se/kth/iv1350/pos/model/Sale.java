package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;
import java.time.LocalTime;
import java.util.HashMap;

/**
 * This class sale has sale related operations and attributes.
 */
public class Sale {
    private LocalTime time;
    private SaleInformation saleInformation;
    private Amount runningTotal;
    private HashMap<ItemDTO, Integer> itemMap = new HashMap<ItemDTO, Integer>();

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        time = LocalTime.now();
        saleInformation = new SaleInformation();
    }

    public HashMap getItemDTOMap() {
        return itemMap;
    }

    /**
     * Appends <code>itemDTO</code> to itemDTOList if there's no duplicate of the specified item.
     * If there is a duplicate of the specified item in the item, update quantity.
     * @param itemDTO
     * @param itemQuantity
     * @return
     */
    public String addItem(ItemDTO itemDTO, int itemQuantity) {
        if(itemMapContains(itemDTO))
            updateQuantity(itemDTO, itemQuantity);
        else
            itemMap.put(itemDTO, itemQuantity);
        String infoToDisplay = itemDTO.getItemDescriptionDTO().toString();
        return infoToDisplay;
    }

    private boolean itemMapContains(ItemDTO itemDTO) {
        return itemMap.containsKey(itemDTO);
    }

    private void updateQuantity(ItemDTO itemDTO, int itemQuantity) {
        itemMap.put(itemDTO, itemMap.get(itemDTO) + itemQuantity);
    }



}
