package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;


/**
 * This is the applications controller. Almost all calls to the model and integration pass through here.
 */
public class Controller {
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem;
    private Printer printer;
    private CashRegister cashRegister;
    private Sale currentSale;

    /**
     * Creates new instance, which
     * @param catalogCreator
     * @param systemCreator
     * @param printer
     */
    public Controller(CatalogCreator catalogCreator, ExternalSystemCreator systemCreator, Printer printer) {
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.discountCatalog = catalogCreator.getDiscountCatalog();
        this.inventorySystem = systemCreator.getInventorySystem();
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.printer = printer;
        this.cashRegister = new CashRegister();
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        currentSale = new Sale();
    }


    public ItemDTO registerItem(int itemID, int itemQuantity) {
        ItemDTO fetchedItem_placeholder = new ItemDTO();

        return fetchedItem_placeholder;
    }
}
