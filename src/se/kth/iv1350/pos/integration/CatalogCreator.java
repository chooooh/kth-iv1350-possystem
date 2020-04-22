package se.kth.iv1350.pos.integration;

/**
 *
 */
public class CatalogCreator {
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;

    public CatalogCreator() {
        itemCatalog = new ItemCatalog();
        discountCatalog = new DiscountCatalog();
    }

    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }

    public DiscountCatalog getDiscountCatalog() {
        return discountCatalog;
    }
}
