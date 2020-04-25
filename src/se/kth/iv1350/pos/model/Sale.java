package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class sale has sale related operations and attributes.
 */
public class Sale {
    private LocalTime time;
    private SaleInformation saleInformation;
    private Amount runningTotal;
    private List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        time = LocalTime.now();
        saleInformation = new SaleInformation();
    }

    public List<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

    //obs! gör hashmap!

    /**
     * Appends <code>itemDTO</code> to itemDTOList if there's no duplicate of the specified item.
     * If there is a duplicate of the specified item in the item, update quantity.
     * @param itemDTO
     */
    public String addItem(ItemDTO itemDTO) {
        ItemDTO item;
        if(itemListContains(itemDTO)) {
            item = getItemDTOWithId(itemDTO.getItemID());
            updateQuantity(itemDTO, item.getItemID());
        } else {
            itemDTOList.add(itemDTO);
        }
        return itemDTO.getItemDescriptionDTO().toString();
    }

    private boolean itemListContains(ItemDTO itemDTO) {
        for(ItemDTO item : itemDTOList) {
            if(item.getItemID() == itemDTO.getItemID())
                return true;
        }
        return false;
    }

    private ItemDTO getItemDTOWithId(int itemID) {
        for(ItemDTO item : itemDTOList) {
            if(item.getItemID() == itemID)
                return item;
        }
        return null;
    }

    private void updateQuantity(ItemDTO item, int itemID) {
        ItemDTO newItem = new ItemDTO(item.getItemID(), item.getItemQuantity() + getItemDTOWithId(itemID).getItemQuantity(), item.getItemDescriptionDTO());
        itemDTOList.remove(item);
        itemDTOList.add(newItem);
    }


//    public void calculateTotal() {
//    }
//
//    /**
//     *
//     * @param discount
//     * @return
//     */
//    public Discount applyDiscount(Discount discount) {
//        return discount;
//    }
}
