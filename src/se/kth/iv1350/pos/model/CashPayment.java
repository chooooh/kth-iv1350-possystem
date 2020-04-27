package se.kth.iv1350.pos.model;

/**
 * This class represents a cash payment of a sale.
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

    void getTotalCost(Sale sale) {
        totalCost = sale.calculateTotal();
    }

    Amount getChange() {
        return paidAmount.minus(totalCost);
    }
}
