package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;

public class Controller {
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private Printer printer;
    private CashRegister cashRegister;

    public Controller(CatalogCreator catalogCreator, ExternalSystemCreator systemCreator, Printer printer) {
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.discountCatalog = catalogCreator.getDiscountCatalog();
        this.printer = printer;
        this.cashRegister = new CashRegister();
    }

    /**
     * Fixa här!
     */
    public void startSale() {
        Sale currentSale = new Sale();
    }
}
