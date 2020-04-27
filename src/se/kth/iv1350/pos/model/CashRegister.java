package se.kth.iv1350.pos.model;

/**
 *
 */
public class CashRegister {
    private Amount balance;

    public CashRegister() {
        balance = new Amount(0);
    }

    public void addPayment(CashPayment payment) {
        balance.add(payment.getPaidAmount());
    }
}
