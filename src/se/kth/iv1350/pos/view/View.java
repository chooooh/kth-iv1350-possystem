package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.Amount;
import se.kth.iv1350.pos.model.RetailStore;

/**
 * This is a placeholder for the real view. The class method <code>sampleExecution</code> contains hardcoded executioner
 * with calls to system operations in the controller.
 */
public class View {
    private Controller controller;

    /**
     * Creates a new instance, that uses the specified controller for all calls to lower layers
     * (according to MVC architecture).
     * @param controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Simulates a sample sale, by calling the necessary operations in the controller.
     */
    public void sampleExecution() {
        controller.startSale();
        controller.setStoreInfo(new RetailStore("IKA", "Stenvägen 123"));

        System.out.println("A new sale has been started");

        System.out.println("Scanned item: " + controller.registerItem(1, 1));
        System.out.println("Scanned item: " + controller.registerItem(1, 1));
        System.out.println("Scanned item: " + controller.registerItem(2, 2));

        System.out.println("Change: " + controller.pay(new Amount(70)) + " kr");
    }
}
