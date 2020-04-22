package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;

public class View {
    private Controller controller;

    /**
     * Creates a new instance. Test
     * @param controller - the controller used for controlling the operations
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Simulates a sale
     */
    public void sampleExecution() {
        controller.startSale();
    }
}
