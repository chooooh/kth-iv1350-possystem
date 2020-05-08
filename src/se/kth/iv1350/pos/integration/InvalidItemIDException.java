package se.kth.iv1350.pos.integration;

/**
 * Thrown when trying to register an item id that does not exist.
 */
public class InvalidItemIDException extends Exception {
    private int itemID;

    /**
     * Creates a nwe instance with a message specifying which item id that does not exist.
     * @param itemID
     */
    public InvalidItemIDException(int itemID) {
        super("Specified itemID does not exist: " + itemID);
        this.itemID = itemID;
    }

    public int getItemIDThatDoesNotExist() {
        return itemID;
    }
}
