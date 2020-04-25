package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale;
    private List<ItemDTO> itemList;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        itemList = new ArrayList<ItemDTO>();
    }

    @AfterEach
    void tearDown() {
        sale = null;
        itemList = null;
    }

    @Test
    void testAddItem() {
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banan", new Amount(20), new Amount(5));
        ItemDTO item = new ItemDTO(123, 1, itemDescriptionDTO);
        sale.addItem(item);
        for(ItemDTO i : sale.getItemDTOList()) {
            System.out.println(i.getItemQuantity());
        }
        sale.addItem(item);
        System.out.println("----");
        for(ItemDTO i : sale.getItemDTOList()) {
            System.out.println(i.getItemQuantity());
        }
        assertTrue(sale.getItemDTOList().contains(item.getItemID()), "The itemDTOList does not contain the test itemDTO.");
    }

    @Test
    void testAddItemEmpty() {
        ItemDescriptionDTO itemDescriptionDTO = new ItemDescriptionDTO("banan", new Amount(20), new Amount(5));
        ItemDTO item = new ItemDTO(123, 1, itemDescriptionDTO);
        assertFalse(sale.getItemDTOList().contains(item.getItemID()), "The itemDTOList does not contain the test itemDTO.");
    }


//    @Test
//    void calculateTotal() {
//    }
//
//    @Test
//    void applyDiscount() {
//    }
}