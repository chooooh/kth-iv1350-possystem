package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Amount;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCatalogTest {
    private DiscountCatalog discountCatalog;

    @BeforeEach
    void setUp() {
        discountCatalog = new DiscountCatalog();
    }

    @AfterEach
    void tearDown() {
        discountCatalog = null;
    }

    @Test
    void TestCheckDiscount() {
        Controller controller = new Controller(new CatalogCreator(), new ExternalSystemCreator(), new Printer());
        String expectedChange = "";
        try {
            controller.startSale();
            controller.registerItem(1, 1);
            controller.checkDiscount(5);
            expectedChange = controller.pay(new Amount(30));
        } catch (InvalidItemIDException e) {
            e.printStackTrace();
        }
        double actualChangeDouble = 30-(12.5*0.5*0.8);
        String actualChange = Double.toString(actualChangeDouble);
        assertEquals(expectedChange, actualChange, "The expected discount object does not match the actual discount.");
    }
}