package Lesson1.Task1;

import java.util.ArrayList;
import java.util.List;

public class HotDrinksVendingMachine {
    private ArrayList<HotDrinks> productList = new ArrayList<>();

    public void addProduct(HotDrinks product) {
        this.productList.add(product);
        System.out.println("Продукт: " + product.name + " успешно добален!");
        System.out.println();
    }


    public HotDrinks getProduct(String name, double price, int volume) {

        for (HotDrinks product : this.productList) {
            if (product.getName().equals(name) & product.getVolume() == volume) {
                return product;
            }
        }
        return null;
    }

}
