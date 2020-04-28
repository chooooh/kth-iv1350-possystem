package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    private CashRegister cashRegister;

    @BeforeEach
    void setUp() {
        cashRegister = new CashRegister();
    }

    @AfterEach
    void tearDown() {
        cashRegister = null;
    }

    @Test
    void addPayment() {
        CashPayment payment = new CashPayment(new Amount(50));
        cashRegister.addPayment(payment);
        Amount expectedBalance = new Amount(50);
        Amount actualBalance = cashRegister.getBalance();
        assertEquals(expectedBalance, actualBalance, "Balances are equal.");
    }
}