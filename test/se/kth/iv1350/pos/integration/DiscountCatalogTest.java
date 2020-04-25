package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void checkDiscount() {

    }
}