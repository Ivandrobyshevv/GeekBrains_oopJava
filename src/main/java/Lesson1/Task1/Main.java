package Lesson1.Task1;

import java.util.*;

public class Main {
    static Scanner output = new Scanner(System.in);
    static Random rand = new Random();
    static HotDrinksVendingMachine listProduct = new HotDrinksVendingMachine();

    static void addProduct() {
        List listTemperature = Arrays.asList(40, 45, 50, 55);

        System.out.print("Название: ");
        String name = output.next();

        System.out.print("Объем: ");
        int volume = output.nextInt();

        System.out.print("Цена: ");
        int price = output.nextInt();
        int temperature = (int) listTemperature.get(rand.nextInt(listTemperature.size()));

        HotDrinks product = new HotDrinks(name, price, volume, temperature);

        listProduct.addProduct(product);
    }

    static void getProduct() {
        System.out.print("Название: ");
        String name = output.next();

        System.out.print("Объем: ");
        int volume = output.nextInt();

        System.out.print("Цена: ");
        double price = output.nextDouble();

        HotDrinks product = listProduct.getProduct(name, price, volume);
        if (product == null) {
            System.out.println("Товар не найден");
        } else {
            System.out.println("\nНазвание: " + product.getName() + "\nОбъем: " + product.getVolume() + "\nТемпература: "
                    + product.getTemperature() + "°C" + "\nЦена: " + product.getPrice() + "РУБ.\n");
        }
    }


    public static void main(String[] args) {
        boolean stop = true;
        while (stop) {
            System.out.println("1-Добавить товар\n2-Получить товар\n3-Выйти");
            int val = output.nextInt();
            switch (val) {
                case 1:
                    addProduct();
                    continue;
                case 2:
                    getProduct();
                    continue;
                case 3:
                    stop = false;

            }
        }
    }
}
