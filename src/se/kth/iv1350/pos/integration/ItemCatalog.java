package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * This method handles the <code>ItemCatalog</code> class. It has several VAT constants. This class uses the Singleton
 * Pattern to restrict more than one instantiations.
 */
public class ItemCatalog {
    private static final ItemCatalog ITEM_CATALOG = new ItemCatalog();

    private List<ItemDTO> itemList = new ArrayList<>();
    private final Amount VAT_TWENTY_FIVE = new Amount(1.25);
    private final Amount VAT_TWELVE = new Amount(1.12);
    private final Amount VAT_FIVE = new Amount(1.05);

    /**
     * Creates an instance. This class holds all item objects.
     */
    private ItemCatalog() {
        addItems();
    }

    /**
     * A get method that returns the only ItemCatalog instance, according to the Singleton Pattern.
     * @return the only ItemCatalog instance.
     */
    public static ItemCatalog getItemCatalog() {
        return ITEM_CATALOG;
    }

    /**
     * Check if the item list contains the specified <code>itemID</code>.
     * @param itemID
     * @return Returns true if the specified itemID is found, else return false.
     */
    public boolean validateItem(int itemID) {
        for(ItemDTO item : itemList) {
            if(item.getItemID() == itemID)
                return true;
        }
        return false;
    }

    /**
     * Fetches the item with corresponding <code>itemID</code>. The <code>itemQuantity</code> parameter decides the amount.
     * If the desired item isn't found, then return null.
     * @param itemID
     * @return Return the found ItemDTO.
     * @throws InvalidItemIDException if the specified item id does not exist.
     * @throws ItemCatalogException if the specified item id is a negative value. This exception serves as a dummy
     * exception for simulating database failure (seminar 4 task 1b) ).
     */
    public ItemDTO fetchItem(int itemID) throws InvalidItemIDException, ItemCatalogException {
        if(itemID < 0)
            throw new ItemCatalogException("Could not connect to the database.");
        for(ItemDTO item : itemList) {
            if(item.getItemID() == itemID)
                return item;
        }
        throw new InvalidItemIDException(itemID);
    }

    /**
     * A dummy method creating sample items. The fourth item added is a sample item that is supposed to trigger a
     * database failure as mentioned in seminar 4 as a suggestion for solving task 1 b)
     */
    private void addItems() {
        ItemDescriptionDTO appleDescription = new ItemDescriptionDTO("Apple", new Amount(10), VAT_TWENTY_FIVE);
        ItemDescriptionDTO milkDescription = new ItemDescriptionDTO("Milk", new Amount(20), VAT_TWELVE);
        ItemDescriptionDTO SpinachDescription = new ItemDescriptionDTO("Spinach", new Amount(30), VAT_TWELVE);
        ItemDescriptionDTO errorDescription = new ItemDescriptionDTO("error", new Amount(0), VAT_TWENTY_FIVE);

        itemList.add(new ItemDTO(1, appleDescription));
        itemList.add(new ItemDTO(2, milkDescription));
        itemList.add(new ItemDTO(3, SpinachDescription));
        itemList.add(new ItemDTO(-1, errorDescription));

    }
}
