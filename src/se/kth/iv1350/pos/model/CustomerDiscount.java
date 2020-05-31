package se.kth.iv1350.pos.model;

/**
 * This class is one of the implementations for the discount interface. This class specifies a discount rate
 * based on the specified customerID.
 */
public class CustomerDiscount implements Discount {
    private int customerID;
    private Amount discountRate = new Amount(1);

    /**
     * Creates an instance with the specified parameters. These parameters will be used to calculate a discount rate
     * based on the conditions.
     * @param customerID The id that is going to get compared.
     * @param discountRate The discount rate 1 gets subtracted with the specified discount rate in order to get
     *                     the correct discount rate.
     */
    public CustomerDiscount(int customerID, Amount discountRate) {
        this.customerID = customerID;
        this.discountRate = this.discountRate.minus(discountRate);
    }


    /**
     * Finds a discount and returns the specified <code>discountRate</code> if the <code>customerID</code> inside
     * <code>currentSale</code> matches the <code>customerID</code> attribute. If the condition does not match,
     * the return value becomes 1 which corresponds to the original price.
     * @param currentSale The ongoing sale which contains the customerID.
     * @param newPrice This argument is needed in order to update the total price.
     * @return the updated price.
     */
    @Override
    public Amount findDiscount(Sale currentSale, Amount newPrice) {
        if(currentSale.getCustomerID() == customerID) {
            Amount discountPriceDifference = newPrice.multiply(discountRate);
            return newPrice.minus(discountPriceDifference);
        } else
            return newPrice;
    }
}
