package se.kth.iv1350.pos.model;

import java.util.Date;

public class Receipt {
    private Date date;
    private SaleInformation saleInformation;

    public Receipt(Date date, SaleInformation saleInformation) {
        this.date = date;
        this.saleInformation = saleInformation;
    }

}
