package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private Receipt receipt;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        receipt = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void createReceipt() {
        Controller controller = new Controller(new CatalogCreator(), new ExternalSystemCreator(), new Printer());
        controller.startSale();
        controller.setStoreInfo(new RetailStore("IKA", "Stenvägen 123"));
        try {
            controller.registerItem(1, 1);
        } catch (InvalidItemIDException e) {
            e.printStackTrace();
        }
        controller.pay(new Amount(50));
        String printout = printoutBuffer.toString();
        String someOfTheExpectedString = "Item: Apple Price: 10.0 kr VAT: 0.25 Quantity: 1";
        assertTrue(printout.contains(someOfTheExpectedString), "The receipt does not contain the expected string.");
    }
}