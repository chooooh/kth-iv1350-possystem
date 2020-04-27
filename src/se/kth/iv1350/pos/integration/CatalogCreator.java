package se.kth.iv1350.pos.integration;

/**
 * This class is responsible for calling the two related classes, <code>ItemCatalog</code> and <code>DiscountCatalog</code>.
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
