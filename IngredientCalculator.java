package CoffeeMachine;

import java.util.Scanner;

public class IngredientCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int water = 200;
        final int milk = 50;
        final int coffeeBeans = 15;

        System.out.println("Write how many cups of coffee you will need: ");

        int cups = scanner.nextInt();

        System.out.println("For 125 cups of coffee you will need: ");
        System.out.println(cups * water + " ml of water");
        System.out.println(cups * milk + " ml of milk");
        System.out.println(cups * coffeeBeans + " g of coffee beans");
    }
}
