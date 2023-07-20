package in.stackroute.ust;

import in.stackroute.ust.domain.Inventory;
import in.stackroute.ust.domain.SortOrder;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inventory management application - proptotype 2.0");

        // this will be the main entry point for the application,
        // this will be a menu-driven application
        // the menu will have the following options:
        // 1. Add item
        // 2. Search item
        // 3. Display all items
        // 4. Exit
        int choice;
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n\t\t\t\t\tMENU\n\t\t\t\t\t....");
            System.out.println(String.format("%1s%30s\n%1s%18s\n%1s%25s",
                    "1: Add an Item","2: Search an Item","3: Display Items","4: Sort","5: Delete","6: Exit"));
            System.out.println("\nEnter your choice: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1: {
                            String name,desc;
                            double price;
                            int qty,code;
                            System.out.println("\nEnter the Details:\n.................");
                            System.out.println("Item Code");
                            code=scanner.nextInt();
                            System.out.println("Item Name: ");
                            name=scanner.next();
                            System.out.println("Item Description: ");
                            desc=scanner.next();
                            System.out.println("Item Price: ");
                            price=scanner.nextDouble();
                            System.out.println("Item Quantity: ");
                            qty=scanner.nextInt();
                            inventory.addItem(code,name,desc,price,qty);
                        }
                        break;
                case 2: {
                            System.out.println("Enter the Item Name: ");
                            inventory.searchItem(scanner.next());
                        }
                        break;
                case 3: inventory.displayItems();
                        break;
                case 4: {
                            System.out.println("Enter Choice\n............\n\t1: Code\n\t2: Name\n\t3: Price");
                            int ch=scanner.nextInt();
                            switch (ch){
                                case 1: inventory.sortList(SortOrder.CODE);
                                break;
                                case 2: inventory.sortList(SortOrder.NAME);
                                break;
                                case 3: inventory.sortList(SortOrder.PRICE);
                                break;
                                default:
                                    System.out.println("Provide a valid input");
                            }
                        }
                        break;
                case 5: inventory.deleteFromList();
                        break;
                case 6: System.out.println("Have a Good Day!");
                        exit(0);
                default: System.out.println("Enter a Valid Choice");
            }
        }while (choice!=6);
    }
}