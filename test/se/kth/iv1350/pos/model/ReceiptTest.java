package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

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
        Sale sale = new Sale();
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO apple = new ItemDTO(1, appleDescription);
        sale.addItem(apple, 1);
        fail("finish this test");
    }
}