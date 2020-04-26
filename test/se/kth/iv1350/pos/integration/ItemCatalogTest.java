package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Amount;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ItemCatalogTest {
    private ItemCatalog itemCatalog;

    @BeforeEach
    void setUp() {
        itemCatalog = new ItemCatalog();
    }

    @AfterEach
    void tearDown() {
        itemCatalog = null;
    }

    @Test
    void TestValidateItem() {
        int itemID = 1;
        boolean expectedResult = true;
        boolean actualResult = itemCatalog.validateItem(1);
        assertEquals(expectedResult, actualResult, "The conditions does not equal.");
    }

    @Test
    void TestFalseValidateItem() {
        assertFalse(itemCatalog.validateItem(9999), "The value does exist.");
    }

    @Test
    void fetchItem() {
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), new Amount(1.25));
        ItemDTO expectedItemDTO = new ItemDTO(1, appleDescription);
        ItemDTO actualItemDTO = itemCatalog.fetchItem(1);
        assertTrue(expectedItemDTO.equals(actualItemDTO), "Items are not equal");
//        assertEquals(expectedID, actualID, "Items are not equal.");
    }
}