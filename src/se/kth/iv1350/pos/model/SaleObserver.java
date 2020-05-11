package se.kth.iv1350.pos.model;

/**
 * A listener interface that receives notifications about the amount paid after every sale since the program started.
 * The class that is interested in such notifications implements this interface.
 */
public interface SaleObserver {

    /**
     * Called when a sale has been paid.
     * @param cashPayment contains the amount that has been paid.
     */
    void newSale(CashPayment cashPayment);
}
