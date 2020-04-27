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

    @Test
    void testMinus() {
        Amount op1 = new Amount(20);
        Amount op2 = new Amount(10);
        Amount expectedAmount = new Amount(10);
        Amount actualAmount = op1.minus(op2);
        assertEquals(expectedAmount, actualAmount, "The difference of the two operands are not correct.");
    }

    @Test
    void testEquals() {
        Amount firstAmount = new Amount(3);
        Amount secondAmount = new Amount(3);
        assertTrue(firstAmount.equals(secondAmount), "The amounts are not equal.");
    }

    @Test
    void testNotEqualsNull() {
        Amount amount = new Amount(0);
        Object other = null;
        boolean expectedBoolean = false;
        boolean actualBoolean = amount.equals(other);
        assertEquals(expectedBoolean, actualBoolean, "The amount instance equal to null.");
    }

    @Test
    void testToString() {
        double representedAmount = 20;
        Amount amount = new Amount(representedAmount);
        String expectedString = "Amount{" +
                "amount=" + representedAmount +
                '}';
        String actualString = amount.toString();
        assertEquals(expectedString, actualString, "The strings returned are not equal.");
    }
}