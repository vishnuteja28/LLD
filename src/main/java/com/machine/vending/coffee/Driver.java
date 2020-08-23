package com.machine.vending.coffee;

import com.machine.vending.coffee.enums.IngredientEnum;

import java.util.Scanner;

public class Driver {

    private static final String INVALID = "Invalid option !!!!!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        VendingMachineOrchestrator vendingMachineManager = new VendingMachineOrchestrator();

        while (true) {

            System.out.println("1. Load Menu");
            System.out.println("2. Load Stock");
            int selectedOption = scanner.nextInt();

            if (selectedOption == 1) {
                System.out.println(vendingMachineManager.getMenu());
                System.out.print("Choose Beverage: ");
                int selectedBeverage = scanner.nextInt();

                if (selectedBeverage >= 1 && selectedBeverage <= 5) {
                    vendingMachineManager.dispenseBeverage(selectedBeverage);
                } else {
                    System.out.println(INVALID);
                }

            } else if (selectedOption == 2) {

                System.out.println(vendingMachineManager.getStock());
                System.out.println("R Refill");
                System.out.println("Q Quit");
                System.out.println("C Continue");

                String selected = scanner.next();

                if (selected.equalsIgnoreCase("r")) {

                    int selectedIngredient = scanner.nextInt();
                    double topUpQuantity = scanner.nextDouble();

                    double updatedStock = vendingMachineManager.stockUp(selectedIngredient, topUpQuantity);

                    System.out.println("Updated Stock : " + IngredientEnum.getName(selectedIngredient) + " >>> " + updatedStock);

                } else if (selected.equalsIgnoreCase("q")) {
                    break;
                }
            } else {
                System.out.println(INVALID);
            }
        }
    }
}
