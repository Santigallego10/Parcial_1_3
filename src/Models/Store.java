package Models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Store
{
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private List<Product> products;
    private List<User> users;

    public Store(String storeName, String storeAddress, String storePhone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", products=" + products +
                ", users=" + users +
                '}';
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(Product product) {
        this.products.remove(product);
    }

    public String[] getProductNames() {
        String[] productNames = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).getName();
        }
        return productNames;
    }

    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void displayInventory() {
        StringBuilder inventoryTable = new StringBuilder();
        inventoryTable.append("Producto\tPrecio\tStock\n");

        for (Product product : products) {
            inventoryTable.append(product.getName())
                    .append("\t\t")
                    .append(product.getPrice())
                    .append("\t")
                    .append(product.getStock())
                    .append("\n");
        }

        inventoryTable.insert(0, "------------------------------------\n");
        inventoryTable.append("------------------------------------\n");

        JOptionPane.showMessageDialog(null, inventoryTable.toString(), "Inventario de " + storeName, JOptionPane.INFORMATION_MESSAGE);
    }
}
