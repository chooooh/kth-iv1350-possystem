package se.kth.iv1350.pos.model;

/**
 * This interface defines the ability to decide whether to add a discount or not based on different discount rules.
 * This interface should be implemented by a class that determines a discount rate based on its implementation.
 */
public interface Discount {
    Amount findDiscount(Sale currentSale, Amount newPrice);
}
