package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.InvalidItemIDException;
import se.kth.iv1350.pos.integration.ItemCatalogException;
import se.kth.iv1350.pos.model.Amount;
import se.kth.iv1350.pos.model.RetailStore;
import se.kth.iv1350.pos.util.LogHandler;
import sun.rmi.runtime.Log;

import java.io.IOException;

/**
 * This is a placeholder for the real view. The class method <code>sampleExecution</code> contains hardcoded executioner
 * with calls to system operations in the controller.
 */
public class View {
    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    LogHandler logger;

    /**
     * Creates a new instance, that uses the specified controller for all calls to lower layers
     * (according to MVC architecture).
     * @param controller
     */
    public View(Controller controller) throws IOException {
        this.controller = controller;
        logger = new LogHandler();
        controller.addSaleObserver(new TotalRevenueView());
    }

    /**
     * Simulates a sample sale, by calling the necessary operations in the controller.
     */
    public void sampleExecution() {
        controller.startSale();
        System.out.println("######################################");
        System.out.println("A new sale has been started");
        System.out.println("");

        controller.setStoreInfo(new RetailStore("IKA", "Stenvägen 123"));

        registerItem(5, 1);
        registerItem(-100, 1);

        registerItem(1, 1);
        registerItem(2, 2);

        System.out.println("");

        System.out.println("Change: " + controller.pay(new Amount(70)) + " kr");
        System.out.println("######################################");
    }


    private void registerItem(int itemID, int quantity) {
        try {
            String scannedItem = controller.registerItem(itemID, quantity);
            System.out.println("Scanned item: " + scannedItem);
        } catch (InvalidItemIDException e) {
            errorMessageHandler.showErrorMsg(e);
            logger.logException(e);
        } catch (ItemCatalogException e) {
            errorMessageHandler.showErrorMsg(e);
            logger.logException(e);
        }
    }

}
