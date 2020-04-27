package se.kth.iv1350.pos.model;

/**
 * This class represents the cash register of the sale.
 */
public class CashRegister {
    private Amount balance;

    /**
     * Creates an instance of the {@link CashRegister} with the balance 0.
     */
    public CashRegister() {
        balance = new Amount(0);
    }

    /**
     * Updates the balance with the {@link Amount} in the {@link CashPayment}.
     * @param payment
     */
    public void addPayment(CashPayment payment) {
        balance.add(payment.getPaidAmount());
    }
}
