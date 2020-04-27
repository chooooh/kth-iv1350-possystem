package se.kth.iv1350.pos.integration;

/**
 * This class is responsible for calling the two related classes,
 * <code>External Accounting System</code> and <code>External Inventory System</code>.
 */
public class ExternalSystemCreator {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;

    /**
     * The constructor creating new instances of <code>ExternalAccountingSystem</code> and <code>ExternalInventorySystem</code>
     */
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
