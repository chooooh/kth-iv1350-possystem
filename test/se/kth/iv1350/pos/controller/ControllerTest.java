package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.CatalogCreator;
import se.kth.iv1350.pos.integration.ExternalSystemCreator;
import se.kth.iv1350.pos.integration.Printer;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller(new CatalogCreator(), new ExternalSystemCreator(), new Printer());
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void startSale() {

    }

    @Test
    void registerItem() {

    }

    @Test
    void checkDiscount() {
    }
}