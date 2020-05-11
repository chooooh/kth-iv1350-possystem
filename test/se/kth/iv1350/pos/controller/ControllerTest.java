package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.CatalogCreator;
import se.kth.iv1350.pos.integration.ExternalSystemCreator;
import se.kth.iv1350.pos.integration.InvalidItemIDException;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.model.Amount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ControllerTest {
    private Controller instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;


    @BeforeEach
    void setUp() {
        instanceToTest = new Controller(new CatalogCreator(), new ExternalSystemCreator(), new Printer());

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void TestItemPriceRegisterItem() {
        instanceToTest.startSale();
        try {
            System.out.println(instanceToTest.registerItem(1,2));
            System.out.println(instanceToTest.registerItem(1,1));
        } catch (InvalidItemIDException e) {
            fail("Failed to register an item");
            e.printStackTrace();
        }

        Amount expectedPrice = new Amount((10*1.25)*3); // (10kr * 0.25% vat) * 3 st
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains(expectedPrice.toString()), "The string does not contain correct item price.");
    }

    @Test
    void TestItemNameRegisterItem() {
        instanceToTest.startSale();
        try {
            System.out.println(instanceToTest.registerItem(1,2));
            System.out.println(instanceToTest.registerItem(2,2));
        } catch (InvalidItemIDException e) {
            fail("Failed to register an item");
            e.printStackTrace();
        }

        String expectedItemName = "Apple";
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains(expectedItemName), "The string does not contain correct item price.");
    }

    @Test
    void TestExceptionRegisterItem() {
        instanceToTest.startSale();
        try {
            System.out.println(instanceToTest.registerItem(9999,2));
            fail("Managed to register invalid items");
        } catch (InvalidItemIDException e) {
            assertTrue(e.getMessage().contains("Specified itemID does not exist: 9999"), "Wrong exception message");
        }
    }
}