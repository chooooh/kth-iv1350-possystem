package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;

import java.util.HashMap;

/**
 * This class is one of the implementations for the discount interface. This class specifies a discount rate
 * based on the specified item quantity.
 */
public class ItemQuantityDiscount implements Discount {
    private int minItemsBoughtForDiscount;
    private Amount discountRate = new Amount(1);

    /**
     * Creates an instance with the specified parameters. These parameters will be used to calculate a discount rate
     * based on the conditions.
     * @param minItemsBoughtForDiscount The minimum item quantity to qualify for the discount rate.
     * @param discountRate The discount rate 1 gets subtracted with the specified discount rate in order to get
     *                     the correct discount rate.
     */
    public ItemQuantityDiscount(int minItemsBoughtForDiscount, Amount discountRate) {
        this.discountRate = this.discountRate.minus(discountRate);
        this.minItemsBoughtForDiscount = minItemsBoughtForDiscount;
    }

    /**
     * Returns the specified <code>discountRate</code> if the <code>itemQuantity</code> inside the <code>currentSale</code>
     * specified as an argument matches the <code>itemQuantity</code> attribute. If the condition does not match,
     * the return value becomes 1 which corresponds to the original price.
     * @param currentSale The ongoing sale that contains the itemMap which in turn contains the <code>item</code> objects.
     * @param newPrice This argument is needed in order to update the total price.
     * @return The updated price.
     */
    @Override
    public Amount findDiscount(Sale currentSale, Amount newPrice) {
        if(minItemsBoughtForDiscount < 0) throw new IllegalArgumentException();
        int itemQuantity = getItemQuantity(currentSale);
        if(itemQuantity >= minItemsBoughtForDiscount) {
            return newPrice.multiply(discountRate);
        } else
            return newPrice;
    }

    private int getItemQuantity(Sale currentSale) {
        HashMap<ItemDTO, Integer> itemMap = currentSale.getItemDTOMap();
        int totalItemQuantity = 0;
        for(int itemQuantity : itemMap.values()) {
            totalItemQuantity += itemQuantity;
        }
        return totalItemQuantity;
    }
}
