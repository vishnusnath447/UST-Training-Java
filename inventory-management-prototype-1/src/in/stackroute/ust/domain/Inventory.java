package in.stackroute.ust.domain;


public class Inventory {

    // class used to manage the items in the inventory
    Item[] inventory = new Item[10];
    int count = 0;
    public void addItem(int id,String name,String desc,double price,int qty){
        Item item = new Item(id,name,desc,price,qty);
        int flag=0;
        for(int i=0;i<count;i++){
            if(inventory[i].getItemCode()==id){
                inventory[i].setItemQty(inventory[i].getItemQty()+qty);
                flag=1;
            }
        }
        if(flag==0) {
            inventory[count]=item;
            count++;
        }
    }

    public void displayItems(){
        double sum=0;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %24s %16s %20s\n", "ITEM ID", "ITEM NAME", "ITEM DESC", "ITEM PRICE", "ITEM QTY");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (int i=0;i<count;i++) {
            System.out.printf("%10s%15s%25s%16s%20s\n",inventory[i].getItemCode(),inventory[i].getItemName(),inventory[i].getItemDesc(),
                    inventory[i].getItemPrice(),inventory[i].getItemQty());
            sum=sum+(inventory[i].getItemQty()*inventory[i].getItemPrice());
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Total Price of Inventory: "+sum);
    }

    public void searchItem(String name){
        int flag=0;
        System.out.println("\nItemId\t\tItemName\tItemDescription\t\t\tItemPrice\tItemQuantity");
        System.out.println("......\t\t........\t...............\t\t\t.........\t............");
        for (int i=0;i<count;i++) {
            if(inventory[i].getItemName().equalsIgnoreCase(name)){
                System.out.println(inventory[i].getItemCode()+"\t\t\t"+inventory[i].getItemName()+"\t\t"+inventory[i].getItemDesc()+
                        "\t\t\t\t"+inventory[i].getItemPrice()+"\t\t"+inventory[i].getItemQty());
                flag=1;
            }
        }
        if(flag == 0){
            System.out.println("Not found.");
        }
    }
}
