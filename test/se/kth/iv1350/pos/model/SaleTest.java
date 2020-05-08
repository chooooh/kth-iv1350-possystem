package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

//    @Test
//    void testAddItem() {
//        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banana", new Amount(20), new Amount(5));
//        ItemDTO item = new ItemDTO(123, itemDescriptionDTO);
//        sale.addItem(item,1);
//    }

    @Test
    void testQuantityAddItem() {
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banana", new Amount(20), new Amount(5));
        ItemDTO item = new ItemDTO(123, itemDescriptionDTO);
        sale.addItem(item,1);
        sale.addItem(item,3);
        int expectedQuantity = 4;
        HashMap<ItemDTO, Integer> map = sale.getItemDTOMap();
        int actualQuantity = map.get(item);
        assertTrue(actualQuantity == expectedQuantity, "quantities are not equal");
    }


    @Test
    void testAddItemEmpty() {
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banana", new Amount(20), new Amount(5));
        ItemDTO item = new ItemDTO(123, itemDescriptionDTO);
        assertFalse(sale.getItemDTOMap().get(item) != null, "The itemDTOList does not contain the test itemDTO.");
    }

    @Test
    void TestCalculateTotal() {
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDescriptionDTO milkDescription = new ItemDescriptionDTO("Milk", new Amount(20), new Amount(1.12));
        ItemDescriptionDTO spinachDescription = new ItemDescriptionDTO("Spinach", new Amount(30), new Amount(1.05));

        sale.addItem(new ItemDTO(1, appleDescription), 3);
        sale.addItem(new ItemDTO(2, milkDescription), 1);
        sale.addItem(new ItemDTO(3, spinachDescription), 1);

        Amount expectedTotalPrice = new Amount((10 * 1.25)*3 + (20 * 1.12) + (30*1.05));
        Amount actualTotalPrice = sale.calculateTotal();

        assertEquals(expectedTotalPrice, actualTotalPrice, "The expected total price and the actual total price are not equal.");
    }

    @Test
    void Pay() {
        Controller controller = new Controller(new CatalogCreator(), new ExternalSystemCreator(), new Printer());
        controller.startSale();
        controller.setStoreInfo(new RetailStore("IKA", "Stenvägen 123"));
        try {
            controller.registerItem(1,1);
        } catch (InvalidItemIDException e) {
            e.printStackTrace();
        }
        CashPayment payment = new CashPayment(new Amount(50));
        String actualChange = controller.pay(payment.getPaidAmount());
        String expectedChange = String.valueOf(50-12.5);
        assertEquals(expectedChange, actualChange, "The amounts are not equal.");
    }



}