package se.kth.iv1350.pos.model;

/**
 * This class is one of the implementations for the discount interface. This class specifies a discount rate
 * based on the specified <code>minTotalForDiscount</code>.
 */
public class SaleDiscount implements Discount {
    private Amount minTotalForDiscount;
    private Amount discountRate = new Amount(1);

    public SaleDiscount(Amount minTotalForDiscount, Amount discountRate) {
        this.discountRate = this.discountRate.minus(discountRate);
        this.minTotalForDiscount = minTotalForDiscount;
    }

    /**
     * Returns the specified <code>discountRate</code> if the <code>runningTotal</code> inside the
     * <code>currentSale</code> matches the <code>minForTotalDiscount</code> attribute.
     * If the condition does not match, the return value becomes 1 which corresponds to the original price.
     * @param currentSale In this method, this object is not necessary.
     * @param newPrice This argument is needed in order to update the total price. It also represents the running total
     *                 that is compared.
     * @return The updated price.
     */
    @Override
    public Amount findDiscount(Sale currentSale, Amount newPrice) {
        if(newPrice.greaterThan(minTotalForDiscount)) {
            return newPrice.multiply(discountRate);
        } else
            return newPrice;
    }
}
