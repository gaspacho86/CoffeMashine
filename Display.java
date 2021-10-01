package CoffeeMachine;

import java.util.Scanner;

class Display {

    static Scanner scanner = new Scanner(System.in);

    static void MainMenu() {

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            switch (scanner.nextLine()) {
                case "buy":
                    CoffeeSelectionMenu();
                    break;
                case "fill":
                    menuFillSupplies();
                    break;
                case "take":
                    System.out.printf("I gave you $%d\n", Resources.MONEY.getRemainder());
                    Resources.MONEY.subtractFromRemainder(Resources.MONEY.getRemainder());
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }
    }

    static void CoffeeSelectionMenu() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String selectedItem = scanner.nextLine();

        if (selectedItem.equals("back")) return;

        if (Coffee.values()[Integer.parseInt(selectedItem) - 1].getMissingSupplies().isEmpty()) {
            System.out.println("I have enough resources, making you a coffee!");
            Coffee.values()[Integer.parseInt(selectedItem) - 1].makePortion();
        } else {
            System.out.printf("Sorry, not enough %s!\n",
                    Coffee.values()[Integer.parseInt(selectedItem) - 1].getMissingSupplies());
        }
    }

    static void menuFillSupplies() {
        for (int i = 0; i < 4; i++) {
            int addedQuantity = scanner.nextInt();
            String[] userRequest = {"Write how many ml of water you want to add:",
                    "Write how many ml of milk you want to add:",
                    "Write how many grams of coffee beans you want to add:",
                    "Write how many disposable cups of coffee you want to add:"};
            System.out.println(userRequest[i]);
            Resources.values()[i].addToRemainder(addedQuantity);
        }
    }

    static void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n\n",
                Resources.WATER.getRemainder(),
                Resources.MILK.getRemainder(),
                Resources.COFFEE_BEANS.getRemainder(),
                Resources.DISPOSABLE_CUPS.getRemainder(),
                Resources.MONEY.getRemainder());
    }
}

