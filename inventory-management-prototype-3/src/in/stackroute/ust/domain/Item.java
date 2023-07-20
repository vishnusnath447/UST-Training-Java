package in.stackroute.ust.domain;

public class Item {

    // class used to represent the items in the inventory
    private int itemCode;
    private String itemName;
    private String itemDesc;
    private double itemPrice;
    private int itemQty;

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    Item(int itemCode, String itemName, String itemDesc, double itemPrice, int itemQty){
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.itemDesc=itemDesc;
        this.itemPrice=itemPrice;
        this.itemQty=itemQty;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s\n",this.getItemCode(),this.getItemName(),this.getItemDesc(),
                this.getItemPrice(),this.getItemQty());
    }
}
