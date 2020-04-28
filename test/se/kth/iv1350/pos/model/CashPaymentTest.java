package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.*;

import static org.junit.jupiter.api.Assertions.*;

class CashPaymentTest {
    private CashPayment cashPayment;

    @BeforeEach
    void setUp() {
        cashPayment = new CashPayment(new Amount(50));
    }

    @AfterEach
    void tearDown() {
        cashPayment = null;
    }

    @Test
    void getTotalCost() {
        Sale sale = new Sale();
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO itemDTO = new ItemDTO(1, appleDescription);
        sale.addItem(itemDTO, 2);
        sale.pay(cashPayment);
        cashPayment.getTotalPrice(sale);
        Amount actualTotalCost = cashPayment.getTotalCost();
        Amount expectedTotalCost = new Amount(10*1.25*2);
        assertEquals(expectedTotalCost, actualTotalCost, "The costs are not equal.");
    }

    @Test
    void TestGetChange() {
        Sale sale = new Sale();
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO apple = new ItemDTO(1, appleDescription);
        sale.addItem(apple, 1);
        cashPayment.getTotalPrice(sale);
        Amount expectedChange = new Amount(50 - 12.5);
        Amount actualChange = cashPayment.getChange();
        assertEquals(expectedChange, actualChange, "The changes are equal.");
    }

    @Test
    void TestFalseGetChange() {
        Sale sale = new Sale();
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO apple = new ItemDTO(1, appleDescription);
        sale.addItem(apple, 1);
        cashPayment.getTotalPrice(sale);
        Amount expectedChange = new Amount(50 - 1000);
        Amount actualChange = cashPayment.getChange();
        assertFalse(expectedChange.equals(actualChange));
    }
}