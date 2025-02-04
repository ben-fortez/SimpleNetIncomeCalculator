package SimpleNetIncomeCalculator;

import java.text.DecimalFormat;


public class Product {
    DecimalFormat df = new DecimalFormat("#.00");
    public String name;
    public double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return name + ": $" + df.format(price);
    }
}
