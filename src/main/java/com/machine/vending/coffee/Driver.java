package com.machine.vending.coffee;

import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.CoffeeVendingMachineRepository;
import com.machine.vending.coffee.service.CoffeeVendingMachine;
import com.machine.vending.coffee.service.CoffeeVendingMachineServiceImpl;

import java.util.Scanner;

public class Driver {

    private static final String INVALID = "Invalid option !!!!!";

    public static void main(String[] args) throws IngredientNotFoundException {

        Scanner scanner = new Scanner(System.in);

        CoffeeVendingMachineRepository coffeeVendingMachineRepository = new CoffeeVendingMachineRepository();
        CoffeeVendingMachine vendingMachine = new CoffeeVendingMachineServiceImpl(coffeeVendingMachineRepository);
        CoffeeVendingMachineOrchestrator vendingMachineOrchestrator = new CoffeeVendingMachineOrchestrator(vendingMachine);

        for (int i = 0; i < Ingredient.IngredientMetadata.values().length; i++) {
            vendingMachine.updateStock(Ingredient.IngredientMetadata.values()[i].getId(), 300);
        }

        while (true) {

            System.out.println();
            System.out.println("1. Load Menu");
            System.out.println("2. Load Stock");
            System.out.println("3. Exit");
            int selectedOption = scanner.nextInt();

            if (selectedOption == 1) {
                vendingMachineOrchestrator.getMenu();
                System.out.print("Choose Beverage: ");
                int selectedBeverage = scanner.nextInt();

                vendingMachineOrchestrator.dispenseBeverage(selectedBeverage);

            } else if (selectedOption == 2) {

                vendingMachineOrchestrator.getStock();

                System.out.println();
                System.out.println("R Refill");
                System.out.println("Q Quit");
                System.out.println("M Main MenuItem");

                String selected = scanner.next();

                if (selected.equalsIgnoreCase("r")) {

                    int selectedIngredient = scanner.nextInt();
                    double topUpQuantity = scanner.nextDouble();

                    vendingMachineOrchestrator.stockUp(selectedIngredient, topUpQuantity);

                } else if (selected.equalsIgnoreCase("q")) {
                    break;
                } else if (selected.equalsIgnoreCase("m")) {
                    continue;
                } else {
                    System.out.println(INVALID);
                }
            } else if (selectedOption == 3) {
                break;
            } else {
                System.out.println(INVALID);
            }
        }
    }
}
