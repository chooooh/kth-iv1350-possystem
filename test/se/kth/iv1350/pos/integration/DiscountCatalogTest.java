package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        Discount expectedDiscount = new Discount(new Amount(0.8));
        Discount actualDiscount = discountCatalog.checkDiscount(100001);
        assertEquals(expectedDiscount, actualDiscount, "The expected discount object does not match the actual discount.");
    }
}