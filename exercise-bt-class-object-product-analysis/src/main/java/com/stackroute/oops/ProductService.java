package com.stackroute.oops;

import java.util.Arrays;

import static com.stackroute.oops.ProductRepository.getProducts;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {

    /*
        Returns the name of the product given the productCode
     */
    public String findProductNameByCode(int productCode) {
        Product[] products = getProducts();
        for (Product product:products) {
            if(product.getProductCode()==productCode){
                return product.getName();
            }
        }
        return null;
    }

    /*
        Returns the Product with maximum price in a given category
     */
    public Product findMaxPriceProductInCategory(String category) {
        Product[] products = getProducts();
        Product result = new Product(0,"",0,"");
        double maxPrice = 0;
        int flag=0;
        for (Product product:products) {
            if(product.getCategory().equalsIgnoreCase(category)){
                if(product.getPrice()>=maxPrice){
                    maxPrice= product.getPrice();
                    result=product;
                    flag=1;
                }
            }
        }
        if(flag==0){
            return null;
        }
        return result;
    }

    /*
        Returns an array of products for a given category
     */
    public Product[] getProductsByCategory(String category) {
        Product[] returnProducts = new Product[8];
        Product[] products = getProducts();
        int i=0,flag=0;
        for (Product product:products) {
            if(product.getCategory().equalsIgnoreCase(category)){
                returnProducts[i]=product;
                i++;
                flag=1;
            }
        }
        if(flag==0){
            return null;
        }
        return Arrays.copyOf(returnProducts,i);
    }
}
