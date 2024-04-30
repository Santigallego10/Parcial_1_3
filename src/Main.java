import Models.Product;
import Models.Store;
import Util.Util;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        Store store = new Store("Tienda CUE","Cra 19 #23 - 12","320900801");

        store.setUsers(Util.generateUserList());

        store.setProducts(Util.generateProductList());

        boolean flag = true;
        while(flag){
            int opcion = mainMenu(store);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    manageProductMessage(store);
                    break;
                case 2:
                    manageInventoryMessage(store);
                    break;
            }
        }
        }

    private static int mainMenu(Store store) {
        String[] opciones
                ={"Salir","Productos","Inventario"};

        int opcion = JOptionPane.showOptionDialog(null,
                "Bienvenido al sistema de inventario",
                store.getStoreName(), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones,
                null);

        return opcion;
    }

    private static void manageInventoryMessage(Store store)
    {
        boolean flag = true;

        String[] opciones
                ={"Menu principal","Aumentar/reducir stock de Producto","Ver inventario"};

        while(flag){

            int opcion = JOptionPane.showOptionDialog(null,
                    "",
                    store.getStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    changeStockMessage(store);
                    break;
                case 2:
                    viewInventory(store);
                    break;
            }
        }
    }

    private static void viewInventory(Store store) {
        store.displayInventory();
    }

    private static void changeStockMessage(Store store) {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto", store.getStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        Product product = store.findByName(name);

        String stock = (String) JOptionPane.showInputDialog(null,"Edite la cantidad","Editar stock",JOptionPane.QUESTION_MESSAGE, null, null, product.getStock());

        product.setStock(Integer.parseInt(stock));
    }

    private static void manageProductMessage(Store store)
    {
        boolean flag = true;

        String[] opciones
                ={"Menu principal","Eliminar Producto","Editar produdcto","Agregar Producto"};

        while(flag){
            int opcion = JOptionPane.showOptionDialog(null,
                    "",
                    store.getStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    deleteProductMessage(store);
                    break;
                case 2:
                    editProductMessage(store);
                    break;
                case 3:
                    addProductMessage(store);
                    break;
            }
        }
    }

    private static void addProductMessage(Store store) {
        String name = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);
        String price = (String) JOptionPane.showInputDialog(null,"Ingrese el precio","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);
        String stock = (String) JOptionPane.showInputDialog(null,"Ingrese la cantidad inicial","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);


        Product product = new Product(name, Double.parseDouble(price),Integer.parseInt(stock));
        store.addProduct(product);
    }

    private static void editProductMessage(Store store) {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto que desea editar", store.getStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        Product product = store.findByName(name);

        String newName = (String) JOptionPane.showInputDialog(null,"Ingrese el nuevo nombre","Editar Producto",JOptionPane.QUESTION_MESSAGE, null, null, product.getName());
        String newPrice = (String) JOptionPane.showInputDialog(null,"Ingrese el nuevo precio","Editar Producto",JOptionPane.QUESTION_MESSAGE, null, null, product.getPrice());

        product.setName(newName);
        product.setPrice(Double.parseDouble(newPrice));
    }

    private static void deleteProductMessage(Store store)
    {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto", store.getStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        int r = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de eliminar el producto?",
                "Confirmar eliminación",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

        Product product = store.findByName(name);
        store.deleteProduct(product);
    }
}