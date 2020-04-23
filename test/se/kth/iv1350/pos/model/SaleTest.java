package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescription;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale;
    private List<ItemDTO> itemDTOList;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        itemDTOList = new ArrayList<ItemDTO>();
    }

    @AfterEach
    void tearDown() {
        sale = null;
        itemDTOList = null;
    }

    @Test
    void testAddItem() {
        ItemDescription itemDescription = new ItemDescription("banan", new Amount(20), new Amount(5));
        ItemDTO itemDTO = new ItemDTO(123, 1, itemDescription);
        sale.addItem(itemDTO);
        // fixa så att sale inte behöver en get metod
        assertTrue(sale.getItemDTOList().contains(itemDTO), "The itemDTOList does not contain the test itemDTO.");
    }

//    @Test
//    void calculateTotal() {
//    }
//
//    @Test
//    void applyDiscount() {
//    }
}