package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

public class Discount {
    private final Amount discount;

    Discount(Amount discount) {
        this.discount = discount;
    }

    public Amount getDiscount() {
        return discount;
    }
}
