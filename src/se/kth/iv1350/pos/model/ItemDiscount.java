package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

import java.util.HashMap;

/**
 * This class is one of the implementations for the discount interface. This class specifies a discount rate
 * based on the specified item.
 */
public class ItemDiscount implements Discount {
    private ItemDTO item;
    private Amount discountRate = new Amount(1);

    /**
     * Creates an instance of the ItemDiscount object. These parameters will be used to calculate a discount rate
     * based on the attribute item specified.
     * @param item The item to compare.
     * @param discountRate The discount rate 1 gets subtracted with the specified discount rate in order to get
     *                     the correct discount rate.
     */
    public ItemDiscount(ItemDTO item, Amount discountRate) {
        this.item = item;
        this.discountRate = this.discountRate.minus(discountRate);
    }

    /**
     * Returns the specified <code>discountRate</code> if the <code>item</code> inside the <code>currentSale</code>
     * specified as an argument matches the <code>item</code> attribute. If the condition does not match,
     * the return value becomes 1 which corresponds to the original price.
     * @param currentSale The ongoing sale that contains the itemMap which in turn contains the <code>item</code> objects.
     * @param newPrice This argument is needed in order to update the total price.
     * @return The updated price.
     */
    @Override
    public Amount findDiscount(Sale currentSale, Amount newPrice) {
        HashMap<ItemDTO, Integer> itemMap = currentSale.getItemDTOMap();
        for(ItemDTO item : itemMap.keySet()) {
            if(item.equals(this.item)) {
                Amount discountPriceDifference = calculateItemPriceDifference(item);
                return newPrice.minus(discountPriceDifference);
            }
        }
        return newPrice;
    }

    private Amount calculateItemPriceDifference(ItemDTO item) {
        Amount itemPriceBeforeDiscount = applyVAT(item);
        System.out.println(itemPriceBeforeDiscount);
        Amount itemPriceAfterDiscount = itemPriceBeforeDiscount.multiply(discountRate);
        System.out.println(itemPriceAfterDiscount);

        return itemPriceBeforeDiscount.minus(itemPriceAfterDiscount);
    }

    private Amount applyVAT(ItemDTO item) {
        ItemDescriptionDTO itemDesc = item.getItemDescriptionDTO();
        Amount itemPrice = itemDesc.getItemPrice();
        Amount itemVAT = itemDesc.getItemVAT();
        return itemPrice.multiply(itemVAT);
    }
}
