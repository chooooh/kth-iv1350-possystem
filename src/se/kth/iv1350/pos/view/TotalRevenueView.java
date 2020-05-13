package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.Amount;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private Amount income = new Amount(0);

    @Override
    public void newSale(CashPayment cashPayment) {
        income.add(cashPayment.getTotalCost());
        printCurrentState();
    }

    private void printCurrentState() {
        System.out.print("\nTotalRevenueView - ");
        System.out.println("Total Income: " + income.getAmount() + "\n");
    }
}
