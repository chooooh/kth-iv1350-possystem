package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiscountCatalog {
    private HashMap<Integer, Discount> discounts = new HashMap<Integer, Discount>();

    /**
     * This constructor calls the <code>addDiscounts</code> methods which puts several sample discounts in discounts <code>map</code>.
     */
    DiscountCatalog() {
        addDiscounts();
    }

    /**
     * This method returns a discount based on specified customerID.
     * @param customerID
     * @return Return discount if specified customerID has a discount, otherwise return the amount 1, as in 100% of the original price.
     */
    public Discount checkDiscount(int customerID) {
        if(discountExists(customerID))
            return discounts.get(customerID);
        Discount standardPrice = new Discount(new Amount(1));
        return standardPrice;
    }

    private boolean discountExists(int customerID) {
        return discounts.containsKey(customerID);
    }

    /**
     * This method puts sample discounts.
     */
    private void addDiscounts() {
        discounts.put(100001, new Discount(new Amount(0.8)));
        discounts.put(100002, new Discount(new Amount(0.6)));
        discounts.put(100003, new Discount(new Amount(0.5)));
    }

}
