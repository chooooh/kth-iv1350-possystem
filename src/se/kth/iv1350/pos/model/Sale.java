package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ExternalAccountingSystem;
import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class sale has sale related operations and attributes.
 */
public class Sale {
    private Amount runningTotal;
    private HashMap<ItemDTO, Integer> itemMap = new HashMap<ItemDTO, Integer>();
    private RetailStore retailStore;
    private CashPayment payment;
    private List<SaleObserver> saleObservers = new ArrayList<>();
    private int customerID;

    /**
     * Registers observers to the saleObservers list. Any observer in the list will get notified when this object changes
     * state.
     * @param observers The observers that should be observed.
     */
    public void addSaleObservers(List<SaleObserver> observers) {
        saleObservers.addAll(observers);
    }

    private void notifyObservers() {
        for(SaleObserver observer : saleObservers) {
            observer.newSale(runningTotal);
        }
    }

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        runningTotal = new Amount(0);
    }

    public HashMap<ItemDTO, Integer> getItemDTOMap() {
        return itemMap;
    }

    RetailStore getRetailStore() {
        return retailStore;
    }

    public Amount getRunningTotal() {
        return runningTotal;
    }

    public CashPayment getPayment() {
        return payment;
    }

    public void setRunningTotal(Amount runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    {}
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Calculates the total sum of the items in the itemMap by initially applying the items' VAT, multiplying the
     * price with the itemQuantity and then summing them.
     * @return The sum of the item prices with VAT included.
     */
    public Amount calculateTotal() {
        Amount sum = new Amount(0);
        for(ItemDTO item : itemMap.keySet()) {
            Amount itemQuantity = new Amount(itemMap.get(item));
            sum.add(applyVAT(item).multiply(itemQuantity));
        }
        return sum;
    }

    private Amount applyVAT(ItemDTO item) {
        ItemDescriptionDTO itemDesc = item.getItemDescriptionDTO();
        Amount itemPrice = itemDesc.getItemPrice();
        Amount itemVAT = itemDesc.getItemVAT();
        return itemPrice.multiply(itemVAT);
    }

    /**
     * Appends <code>itemDTO</code> to itemDTOList if there's no duplicate of the specified item.
     * If there is a duplicate of the specified item in the item, update quantity.
     * @param itemDTO
     * @param itemQuantity
     * @return String to display on the view.
     */
    public String addItem(ItemDTO itemDTO, int itemQuantity) {
        if(itemMapContains(itemDTO))
            updateQuantity(itemDTO, itemQuantity);
        else
            itemMap.put(itemDTO, itemQuantity);
        addItemPriceToRunningTotal(applyVAT(itemDTO), itemQuantity);
        String infoToDisplay = itemDTO.getItemDescriptionDTO().toString();
        return infoToDisplay;
    }

    private void addItemPriceToRunningTotal(Amount itemPrice, int itemQuantity) {
        runningTotal.add(itemPrice.multiply(new Amount(itemQuantity)));
    }

    private boolean itemMapContains(ItemDTO itemDTO) {
        return itemMap.containsKey(itemDTO);
    }

    private void updateQuantity(ItemDTO itemDTO, int itemQuantity) {
        itemMap.put(itemDTO, itemMap.get(itemDTO) + itemQuantity);
    }

    /**
     * This method handles the pay operation by invoking necessary operations. This method also
     * @param payment the customers payment.
     * @return the amount of change to give to the customer.
     */
    public Amount pay(CashPayment payment) {
        this.payment = payment;
        payment.getTotalPrice(this);
        Receipt receipt = new Receipt(this);
        new ExternalAccountingSystem().updateInformation(this);
        new ExternalInventorySystem().updateInformation(this);
        System.out.println(receipt.createReceipt());
        notifyObservers();
        return payment.getChange();
    }

    public void setStoreInfo(RetailStore retailStore) {
        this.retailStore = retailStore;
    }
}
