package se.kth.iv1350.pos.integration;

import java.util.Objects;

/**
 * This class contains all information about item objects.
 */
public class ItemDTO {
    private final int itemID;
    private final ItemDescriptionDTO itemDescriptionDTO;

    /**
     * Creates a new instance of the itemDTO.
     * @param itemID
     * @param itemDescriptionDTO
     */
    public ItemDTO(int itemID, ItemDescriptionDTO itemDescriptionDTO) {
        this.itemID = itemID;
        this.itemDescriptionDTO = itemDescriptionDTO;
    }

    public int getItemID() {
        return itemID;
    }

    public ItemDescriptionDTO getItemDescriptionDTO() {
        return itemDescriptionDTO;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemID=" + itemID +
                ", itemDescriptionDTO=" + itemDescriptionDTO +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemDTO other = (ItemDTO) obj;
        return itemID == other.itemID &&
                Objects.equals(itemDescriptionDTO, other.itemDescriptionDTO);
    }

}
