package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.CatalogCreator;
import se.kth.iv1350.pos.integration.ExternalSystemCreator;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.view.View;

import java.io.IOException;

/**
 * Starts the application, contains the main method used to start the application.
 */
public class Main {

    /**
     * The main method used to start the application.
     * @param args The application will not take any command line parameters.
     */
    public static void main(String[] args) {
        try {
            CatalogCreator catalogCreator = new CatalogCreator();
            ExternalSystemCreator systemCreator = new ExternalSystemCreator();
            Printer printer = new Printer();
            Controller controller = new Controller(catalogCreator, systemCreator, printer);
            View view = new View(controller);
            view.sampleExecution();
        } catch (IOException e) {
            System.out.println("Unable to start the application");
            e.printStackTrace();
        }
    }
}
