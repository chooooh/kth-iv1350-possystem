package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.Objects;

public class Discount {
    private final Amount discount;

    Discount(Amount discount) {
        this.discount = discount;
    }

    public Amount getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return Objects.equals(discount, discount1.discount);
    }
}
