package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.Objects;

/**
 * This class handles the discount operation.
 */
public class Discount {
    private final Amount discount;

    /**
     * The constructor gets called and assigns a discount as its attribute.
     * @param discount The amount of discount to reduce the price.
     */
    Discount(Amount discount) {
        this.discount = discount;
    }

    public Amount getDiscount() {
        return discount;
    }

    /**
     * This method compares this Discount object with another object, and returns true if they're the same Discount object.
     * @param other The other object to compare with.
     * @return returns true if the both objects are of the Discount class and are the same, else false.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Discount discount1 = (Discount) other;
        return Objects.equals(discount, discount1.discount);
    }
}
