package Lesson1.Task1;

public class Product {
    protected String name;
    protected int price;

    protected int volume;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}

class HotDrinks extends Product {
    protected int volume;
    protected int temperature;

    public HotDrinks(String name, int price, int volume, int temperature) {
        super(name, price);
        this.volume = volume;
        this.temperature = temperature;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getTemperature() {
        return this.temperature;
    }
}
