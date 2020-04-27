package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.HashMap;

public class DiscountCatalog {
    private HashMap<Integer, Discount> discounts = new HashMap<Integer, Discount>();

    /**
     * This constructor calls the <code>addDiscounts</code> methods which puts several sample discounts in discounts <code>map</code>.
     * The whole discount operation  can be omitted according to seminar 3.
     */
    DiscountCatalog() {
        addDiscounts();
    }

    /**
     * This method returns a discount based on specified customerID. This is currently not used
     * since discount operation can be omitted in seminar 3.
     * @param customerID
     * @return Return discount if specified customerID has a discount, otherwise return the amount 1, as in 100% of the original price.
     */
    public Discount checkDiscount(int customerID) {
        if(discountExists(customerID))
            return discounts.get(customerID);
        Discount standardPrice = new Discount(new Amount(1));
        return standardPrice;
    }

    /**
     * This method checks if the discounts currently exists in the <code>HashMap discounts</code>.
     * @param customerID The method uses the customerID as a key in the <code>HashMap discounts</code>
     * @return returns true or false. This method returns true if the <code>HashMap discounts</code> contains the key customerID.
     */
    private boolean discountExists(int customerID) {
        return discounts.containsKey(customerID);
    }

    /**
     * This method puts sample discounts in the <code>HashMap discounts</code>
     */
    private void addDiscounts() {
        discounts.put(100001, new Discount(new Amount(0.8)));
        discounts.put(100002, new Discount(new Amount(0.6)));
        discounts.put(100003, new Discount(new Amount(0.5)));
    }

}
