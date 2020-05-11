package se.kth.iv1350.pos.integration;

/**
 * This class is thrown when something goes wrong during an operation in <code>ItemCatalogException</code>.
 */
public class ItemCatalogException extends RuntimeException {

    /**
     * Creates a new instance representing the error in the specified string.
     * @param msg message that describes the error.
     */
    public ItemCatalogException(String msg) {
        super(msg);
    }
}
