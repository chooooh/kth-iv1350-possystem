package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

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
     * Calculates the total sum of the items in the itemMap by initially applying the items' VAT, multiplying the
     * price with the itemQuantity and then summing them.
     * @return The sum of the item prices with VAT included.
     */
    public Amount calculateTotal() {
        Amount sum = new Amount(0);
        for(ItemDTO item : itemMap.keySet()) {
            Amount itemQuantity = new Amount(itemMap.get(item));
            sum.add(applyVAT(item).multiply(itemQuantity));
        }
        return sum;
    }

    private Amount applyVAT(ItemDTO item) {
        ItemDescriptionDTO itemDesc = item.getItemDescriptionDTO();
        Amount itemPrice = itemDesc.getItemPrice();
        Amount itemVAT = itemDesc.getItemVAT();
        return itemPrice.multiply(itemVAT);
    }

    /**
     * Appends <code>itemDTO</code> to itemDTOList if there's no duplicate of the specified item.
     * If there is a duplicate of the specified item in the item, update quantity.
     * @param itemDTO
     * @param itemQuantity
     * @return Returns string to display in view.
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
