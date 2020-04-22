package se.kth.iv1350.pos.integration;

/**
 *
 * @author choh-
 */
public class ExternalSystemCreator {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;

    public ExternalSystemCreator() {
        accountingSystem = new ExternalAccountingSystem();
        inventorySystem = new ExternalInventorySystem();
    }

    public ExternalAccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    public ExternalInventorySystem getInventorySystem() {
        return inventorySystem;
    }



}
