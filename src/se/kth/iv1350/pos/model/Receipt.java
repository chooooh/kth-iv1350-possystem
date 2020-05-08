package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemDescriptionDTO;

import java.util.Date;
import java.util.HashMap;

/**
 * Represents the receipt of a sale.
 */
public class Receipt {
    private Sale currentSale;

    public Receipt(Sale currentSale) {
        this.currentSale = currentSale;
    }

    /**
     * Writes sale information on the receipt.
     * @return Receipt information which gets displayed on the view.
     */
    public String createReceipt() {
        StringBuilder sb = new StringBuilder();
        endLine(sb);

        sb.append("-----------------------------------");
        endLine(sb);

        sb.append("Store: ");
        RetailStore store = currentSale.getRetailStore();
        if(store != null) {
            sb.append(store.getStoreName());
            sb.append(", ");
            sb.append(currentSale.getRetailStore().getStoreAddress());
            endLine(sb);
        }

        appendLine(sb, new Date().toString());
        endLine(sb);

        appendAllItems(sb);
        sb.append("\n");
        endLine(sb);

        sb.append("Total: ");
        sb.append(currentSale.getRunningTotal().getAmount());
        sb.append(" kr");
        endLine(sb);

        sb.append("-----------------------------------");
        endLine(sb);


        return sb.toString();
    }

    private void appendAllItems(StringBuilder sb) {
        HashMap<ItemDTO, Integer> itemMap = currentSale.getItemDTOMap();
        for(ItemDTO item : itemMap.keySet()) {
            ItemDescriptionDTO itemDescription = item.getItemDescriptionDTO();
            sb.append("Item: ");
            sb.append(itemDescription.getItemName());
            sb.append(" Price: ");
            sb.append(itemDescription.getItemPrice().getAmount());
            sb.append(" kr");
            sb.append(" VAT: ");
            sb.append(itemDescription.getItemVAT().minus(new Amount(1)).getAmount());
            sb.append(" Quantity: " );
            sb.append(itemMap.get(item));
            endLine(sb);
        }
    }

    private void appendLine(StringBuilder sb, String line) {
        sb.append(line);
        sb.append("\n");
    }

    private void endLine(StringBuilder sb) {
        sb.append("\n");
    }

}
