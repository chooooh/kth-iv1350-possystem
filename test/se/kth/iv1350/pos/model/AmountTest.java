package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    private Amount amount;

    @BeforeEach
    void setUp() {
        amount = new Amount(0);
    }

    @AfterEach
    void tearDown() {
        amount = null;
    }

    @Test
    void add() {
        amount.add(new Amount(10));
        Amount expectedAmount = new Amount(10);
        Amount actualAmount = amount;
        assertEquals(expectedAmount, actualAmount, "The expected and actual amount are not equal.");
    }

    @Test
    void multiply() {
        amount = new Amount(5);
        Amount actualAmount = amount.multiply(new Amount(2));
        Amount expectedAmount = new Amount(10);
        assertEquals(expectedAmount, actualAmount, "The expected and actual amount are not equal.");
    }
}