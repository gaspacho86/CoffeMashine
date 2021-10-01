package CoffeeMachine;

import java.util.Scanner;

public class EstimateTheNumberOfServings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] userInteraction = {"Write how many ml of water the coffee machine has: ",
                                    "Write how many ml of milk the coffee machine has: ",
                                    "Write how many grams of coffee beans the coffee machine has:",
                                    "Write how many cups of coffee you will need: "};

        int[] ingredientsPerCup = {200, 50, 15}; // water, milk, coffeeBeans
        int[] ingredientsInStock = new int[3]; // water, milk, coffeeBeans

        for (int i = 0; i < ingredientsInStock.length; i++) {
            System.out.println(userInteraction[i]);
            ingredientsInStock[i] = scanner.nextInt();
        }

        System.out.println(userInteraction[3]);
        int requiredNumberOfCups = scanner.nextInt();

        int numberCupsCanMake = Math.min(ingredientsInStock[2]/ingredientsPerCup[2],
                            Math.min(ingredientsInStock[0]/ingredientsPerCup[0],
                                     ingredientsInStock[1]/ingredientsPerCup[1]));

        if (numberCupsCanMake < requiredNumberOfCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", numberCupsCanMake);
        } else if (numberCupsCanMake == requiredNumberOfCups){
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n",
                    numberCupsCanMake - requiredNumberOfCups);
        }
    }
}
