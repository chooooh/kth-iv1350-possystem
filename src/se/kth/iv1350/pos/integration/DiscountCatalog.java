package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;

import java.util.ArrayList;
import java.util.List;

public class DiscountCatalog {
    private List<Discount> discounts = new ArrayList<>();

    /**
     * This constructor calls the <code>addDiscounts</code> methods which puts several sample discounts in discounts <code>map</code>.
     * The whole discount operation  can be omitted according to seminar 3.
     */
    DiscountCatalog() {
        addDiscounts();
    }

    /**
     * This method implements the strategy pattern and therefore checks the discounts list
     * and applies different discounts.
     * @param currentSale Most of the discount strategies uses the currentSale to grab necessary objects in order
     *                    to check the eligibility of the specified discount conditions.
     * @return Return discounts according to the specified discount rules found in the discounts list
     * otherwise return the original price.
     */
    public Amount checkDiscount(Sale currentSale) {
        Amount newTotalPrice = currentSale.getRunningTotal();
        for(Discount discount : discounts) {
            newTotalPrice = discount.findDiscount(currentSale, newTotalPrice);
        }
        return newTotalPrice;
    }

    /**
     * This method puts sample discounts in the <code>HashMap discounts</code>
     *
     */
    private void addDiscounts() {
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO apple =  new ItemDTO(1, appleDescription);

        discounts.add(new CustomerDiscount(5, new Amount(0.5)));
        discounts.add(new SaleDiscount(new Amount(20), new Amount(0.2)));
        discounts.add(new ItemDiscount(apple, new Amount(0.1)));
        discounts.add(new ItemQuantityDiscount(2, new Amount(0.1)));

    }

}
