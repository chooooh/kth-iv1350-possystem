package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the applications controller. Almost all calls to the model and integration pass through here.
 */
public class Controller {
    private ItemCatalog itemCatalog;
    private DiscountCatalog discountCatalog;
    private Sale currentSale;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates new instance, which
     * @param catalogCreator
     * @param systemCreator
     * @param printer
     */
    public Controller(CatalogCreator catalogCreator, ExternalSystemCreator systemCreator, Printer printer) {
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.discountCatalog = catalogCreator.getDiscountCatalog();
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        currentSale = new Sale();
    }

    public void setStoreInfo(RetailStore retailStore) {
        currentSale.setStoreInfo(retailStore);
    }


    /**
     * This method checks if the specified itemID is valid, if it is valid, return the matching item. Else, return null.
     * The parameter itemQuantity specifies the quantity.
     * @param itemID
     * @param itemQuantity
     * @return The item retrieved when using this method.
     * @throws InvalidItemIDException if the specified item id does not exist
     */
    public String registerItem(int itemID, int itemQuantity) throws InvalidItemIDException {
        boolean itemIsValid = itemCatalog.validateItem(itemID);
        if(itemIsValid) {
            ItemDTO fetchedItem = itemCatalog.fetchItem(itemID);
            currentSale.addItem(fetchedItem, itemQuantity);
            return fetchedItem.getItemDescriptionDTO().toString() + ", running total: " + currentSale.getRunningTotal();
        } else
            throw new InvalidItemIDException(itemID);
    }

    /**
     * This method calls all necessary operations in order to retrieve a discount.
     * @param customerID
     * @return A string discount to display on the view.
     */
    public String checkDiscount(int customerID) {
        currentSale.setCustomerID(customerID);
        Amount newTotalPrice = discountCatalog.checkDiscount(currentSale);
        currentSale.setRunningTotal(newTotalPrice);
        String infoToDisplay = newTotalPrice.toString();
        return infoToDisplay;
    }

    /**
     * This method handles the pay operation. The method updates the <code>CashRegister</code> and then adds a payment
     * to the current sale.
     * @param paidAmount The cashier writes how much the client has paid.
     * @Return This method returns the amount of change, which is displayed on the view.
     */
    public String pay(Amount paidAmount) {
        CashPayment cashPayment = new CashPayment(paidAmount);
        CashRegister cashRegister = new CashRegister();
        cashRegister.addPayment(cashPayment);
        currentSale.addSaleObservers(saleObservers);
        return String.valueOf(currentSale.pay(cashPayment).getAmount());
    }

    /**
     * The specified observer will be notified when a sale has been completed.
     * @param observer The observer to notify.
     */
    public void addSaleObserver(SaleObserver observer) {
        saleObservers.add(observer);
    }

}
