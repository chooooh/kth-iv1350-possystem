package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.Discount;
import se.kth.iv1350.pos.integration.ItemDTO;
import java.time.LocalTime;

/**
 * This class sale has sale related operations and attributes.
 */
public class Sale {
    private LocalTime time;
    private SaleInformation saleInformation;
    private Amount runningTotal;
    // använd List!
    private ItemDTO[] itemDTO;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        time = LocalTime.now();
        saleInformation = new SaleInformation();
    }


    public void addItem(ItemDTO itemDTO) {
    }

    public void calculateTotal() {
    }

    /**
     *
     * @param discount
     * @return
     */
    public Discount applyDiscount(Discount discount) {

        return discount;
    }
}
