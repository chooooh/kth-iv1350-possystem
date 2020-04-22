package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.Discount;
import se.kth.iv1350.pos.integration.ItemDTO;

public class Sale {
    //    private localTime time;
    private SaleInformation saleInformation;
    private Amount runningTotal;
    // använd List!
    private ItemDTO[] itemDTO;

    public Sale() {
        saleInformation = new SaleInformation();
    }

    /**
     * Sets the current time of sale
     */
    private void setTimeOfSale() {
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
