package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the external accounting system. However, the seminar states that this class can simply be omitted.
 */
public class ExternalAccountingSystem {
    private List<Sale> sales = new ArrayList<Sale>();
    public ExternalAccountingSystem() {
    }

    /**
     * Dummy method simulating an update of information
     */
    public void updateInformation(Sale sale) {
        System.out.println("Updating information..");
        sales.add(sale);
    }
}
