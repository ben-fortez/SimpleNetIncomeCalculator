package SimpleNetIncomeCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleNetIncomeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<ProductIncome> productIncomes = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.00");

        // Introduction
        System.out.println("Welcome to the Simple Net Income Calculator!");

        // Make Products
        System.out.println("Please enter the number of products at your store:");
        int numOfProducts = sc.nextInt();

        // Check to see if number of products is <= 0
        if (numOfProducts <= 0) {
            throw new IllegalArgumentException("Number of products must be greater than 0");
        }

        sc.nextLine();

        for (int i = 1; i <= numOfProducts; i++) {
            System.out.println("Enter product #" + i + ":");
            String name = sc.nextLine();
            System.out.println("Enter price of " + name + ":");
            double price = sc.nextDouble();
            sc.nextLine();
            Product product = new Product(name, price);
            products.add(product);
        }

        // Print out list of products w/ prices
        System.out.println("\nPrices: ");
        for (int productIndex = 0; productIndex < products.size(); productIndex++) {
            System.out.println(products.get(productIndex).toString());
        }

        System.out.println("\nA month has passed. Let's calculate the total earnings for this period!\n");

        // User inputs how many products are sold
        for (int productIndex = 0; productIndex < products.size(); productIndex++) {
            String name = products.get(productIndex).getName();
            System.out.println("How many " + name + " did you sell?");
            int amountSold = sc.nextInt();
            sc.nextLine();
            double price = products.get(productIndex).getPrice();
            double amountEarned = amountSold * price;
            ProductIncome productIncome = new ProductIncome(name, price, amountEarned);
            productIncomes.add(productIncome);
        }

        // Print out list of products w/ amount earned & total amount earned
        double totalEarnedAmount = 0;
        System.out.println("\nEarned Amount: ");
        for (int productIndex = 0; productIndex < productIncomes.size(); productIndex++) {
            System.out.println(productIncomes.get(productIndex).toString());
            totalEarnedAmount += productIncomes.get(productIndex).getEarnedAmount();
        }
        System.out.println("\nIncome: $" + df.format(totalEarnedAmount));

        // User inputs expenses
        System.out.println("\nEnter your staff expenses: ");
        double staffExpenses = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter your other expenses: ");
        double otherExpenses = sc.nextDouble();
        sc.nextLine();

        // Calculate net income
        double netIncome = totalEarnedAmount - (staffExpenses + otherExpenses);
        System.out.println("\nYour net income: $" + df.format(netIncome));
    }
}
