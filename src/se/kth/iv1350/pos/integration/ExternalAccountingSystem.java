package se.kth.iv1350.pos.integration;

public class ExternalAccountingSystem {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;

    public ExternalAccountingSystem() {
        accountingSystem = new ExternalAccountingSystem();
        inventorySystem = new ExternalInventorySystem();
    }

    public ExternalAccountingSystem getExternalAccountingSystem() {
        return accountingSystem;
    }

    public ExternalInventorySystem getExternalInventorySystem() {
        return inventorySystem;
    }
}
