package Util;

import Models.Product;
import Models.User;

import java.util.ArrayList;
import java.util.List;

public class Util {

    //Genera una lista de usuarios base
    public static List<User> generateUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Santi", "Gallego", "santig@cue.com"));
        userList.add(new User(2, "Mari", "Hurtado", "marih@cue.com"));
        userList.add(new User(3, "Santi", "Jaramillo", "santij@cue.com"));

        return userList;
    }

    //Genera una lista de productos base
    public static List<Product> generateProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Water Bottle x 500ML",2500,24));
        productList.add(new Product("Coca Cola x 400ML",3000,12));
        productList.add(new Product("Candy Bar - Cherry",1500,10));
        productList.add(new Product("Orange Juice x 1L",9900,12));
        productList.add(new Product("White Bread x 6",3000,24));
        productList.add(new Product("Brownie",4500,6));

        return productList;
    }
}
