package se.kth.iv1350.pos.model;

/**
 * This class represents a cash payment of a {@link Sale}.
 */
public class CashPayment {
    private Amount paidAmount;
    private Amount totalCost;

    public CashPayment(Amount paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Amount getPaidAmount() {
        return paidAmount;
    }

    public Amount getTotalCost() {
        return totalCost;
    }

    /**
     * Gets the total cost by calling the method calculateTotal from {@link Sale}.
     * @param sale
     */
    void getTotalPrice(Sale sale) {
        totalCost = sale.getRunningTotal();
    }

    /**
     * Gets the change by subtracting the paid {@link Amount} with the total cost.
     * @return
     */
    Amount getChange() {
        return paidAmount.minus(totalCost);
    }
}
