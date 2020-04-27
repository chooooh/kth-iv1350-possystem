package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.Amount;

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
        System.out.println("A new sale has been started");

        controller.registerItem(1, 1);
        controller.pay(new Amount(50));

    }
}
