package in.stackroute.ust.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.exit;

public class Inventory {

    // class used to manage the items in the inventory
    List<Item> inventory = new ArrayList<>();

    public void addItemToList(int code,String name,String desc,double price,int qty){
        Item item = new Item(code,name,desc,price,qty);
        int flag=0;
        for(Item items:inventory){
            if(code == items.getItemCode()){
                flag=1;
                items.setItemQty(items.getItemQty()+qty);
            }
        }
        if(flag==0) {
            inventory.add(item);
        }
        FileManager fileManager = new FileManager();
        fileManager.writeToFile(item);
    }

    public void displayItems(){
        double sum=0;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %24s %16s %20s\n" +
                "", "ITEM CODE", "ITEM NAME", "ITEM DESC", "ITEM PRICE", "ITEM QTY");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Item item:inventory) {
            System.out.printf("%10s%15s%25s%16s%20s\n",item.getItemCode(),item.getItemName(),item.getItemDesc(),
                    item.getItemPrice(),item.getItemQty());
            sum=sum+(item.getItemQty()*item.getItemPrice());
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Total Price of Inventory: "+sum);
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public void searchItem(String name){
        int flag=0;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %24s %16s %20s\n" +
                "", "ITEM CODE", "ITEM NAME", "ITEM DESC", "ITEM PRICE", "ITEM QTY");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Item item:inventory) {
            if(item.getItemName().equals(name)){
                System.out.printf("%10s%15s%25s%16s%20s\n",item.getItemCode(),item.getItemName(),item.getItemDesc(),
                        item.getItemPrice(),item.getItemQty());
                flag=1;
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        if(flag == 0){
            System.out.println("Not found.");
        }
    }

    public void sortList(SortOrder sortOrder) {
        if(sortOrder == SortOrder.CODE){
            Comparator<Item> comparatorId = new Comparator<>() {
                @Override
                public int compare(Item i1, Item i2) {
                    Integer first=i1.getItemCode();
                    Integer second= i2.getItemCode();
                    return first.compareTo(second);
                }
            };
            inventory.sort(comparatorId);
        }
        else if(sortOrder == SortOrder.NAME){
            Comparator<Item> comparatorName = new Comparator<>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return i1.getItemName().compareTo(i2.getItemName());
                }
            };
            inventory.sort(comparatorName);
        }
        else if(sortOrder == SortOrder.PRICE){
            Comparator<Item> comparatorPrice = new Comparator<>() {
                @Override
                public int compare(Item i1, Item i2) {
                    Double first=i1.getItemPrice();
                    Double second= i2.getItemPrice();
                    return first.compareTo(second);
                }
            };
            inventory.sort(comparatorPrice);
        }
        System.out.println("---------------------------------");
        System.out.println("Sorted! Check the display option.");
        System.out.println("---------------------------------");
    }

    public void deleteFromList() {
    }
}
