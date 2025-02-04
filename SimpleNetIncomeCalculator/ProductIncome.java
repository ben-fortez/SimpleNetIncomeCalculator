package SimpleNetIncomeCalculator;

import java.text.DecimalFormat;

public class ProductIncome extends Product {
    DecimalFormat df = new DecimalFormat("#.00");
    public double earnedAmount;

    public ProductIncome(String name, double price, double earnedAmount) {
        super(name, price);
        this.earnedAmount = earnedAmount;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public double getEarnedAmount(){
        return earnedAmount;
    }

    public String toString(){
        return name + ": $" + df.format(earnedAmount);
    }

}
