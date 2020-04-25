package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

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
//        for(ItemDTO searchedItem : map.keySet()) {
//            if(searchedItem.equals(item))
//                actualQuantity = map.get(searchedItem);
//        }
        assertTrue(actualQuantity == expectedQuantity, "quantities are not equal");
    }


    @Test
    void testAddItemEmpty() {
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banana", new Amount(20), new Amount(5));
        ItemDTO item = new ItemDTO(123, itemDescriptionDTO);
        assertFalse(sale.getItemDTOMap().get(item) != null, "The itemDTOList does not contain the test itemDTO.");
    }
}