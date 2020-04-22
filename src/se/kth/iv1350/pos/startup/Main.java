package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.CatalogCreator;
import se.kth.iv1350.pos.integration.ExternalSystemCreator;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.view.View;

public class Main {
    public static void main(String[] args) {
        CatalogCreator catalogCreator = new CatalogCreator();
        ExternalSystemCreator systemCreator = new ExternalSystemCreator();
        Printer printer = new Printer();

        Controller controller = new Controller(catalogCreator, systemCreator, printer);

        View view = new View(controller);
    }
}
