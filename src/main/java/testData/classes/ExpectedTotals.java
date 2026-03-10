package testData.classes;

import utils.Reader;

public class ExpectedTotals {

    private String itemTotal;
    private String tax;
    private String total;

    // Constructor
    public ExpectedTotals(String filename) {
        this.itemTotal = Reader.json(filename).get("itemTotal").toString();
        this.tax = Reader.json(filename).get("tax").toString();
        this.total = Reader.json(filename).get("total").toString();
    }


    public String getItemTotal() {
        return itemTotal;
    }

    public String getTax() {
        return tax;
    }

    public String getTotal() {
        return total;
    }


    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public void settotal(String total) { this.total = total;

    }
}
