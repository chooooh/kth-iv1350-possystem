package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.Discount;
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

    /**
     * Appends <code>itemDTO</code> to itemDTOList
     * @param itemDTO
     */
    public void addItem(ItemDTO itemDTO) {
        itemDTOList.add(itemDTO);
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
