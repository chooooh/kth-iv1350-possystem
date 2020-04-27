package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.Amount;
import se.kth.iv1350.pos.model.CashPayment;
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


    /**
     * This method checks if the specified itemID is valid, if it is valid, return the matching item. Else, return null.
     * The parameter itemQuantity specifies the quantity.
     * @param itemID
     * @param itemQuantity
     * @return The item retrieved when using this method.
     */
    public String registerItem(int itemID, int itemQuantity) {
        boolean itemIsValid = itemCatalog.validateItem(itemID);
        if(itemIsValid) {
            ItemDTO fetchedItem = itemCatalog.fetchItem(itemID);
            currentSale.addItem(fetchedItem, itemQuantity);
            return fetchedItem.getItemDescriptionDTO().toString() + ", running total: " + currentSale.getRunningTotal();
        }
        return null;
    }

    /**
     * This method calls all necessary operations in order to retrieve a discount.
     * @param customerID
     * @return A string discount to display on the view.
     */
    public String checkDiscount(int customerID) {
        Discount discount = discountCatalog.checkDiscount(customerID);
        String infoToDisplay = discount.getDiscount().toString();
        return infoToDisplay;
    }

    /**
     * This method handles the pay operation. The method updates the <code>CashRegister</code> and then adds a payment
     * to the current sale.
     * @param paidAmount The cashier writes how much the client has paid.
     */
    public void pay(Amount paidAmount) {
        CashPayment cashPayment = new CashPayment(paidAmount);
        CashRegister cashRegister = new CashRegister();
        cashRegister.addPayment(cashPayment);
        System.out.println(currentSale.pay(cashPayment).getAmount());
    }

}
