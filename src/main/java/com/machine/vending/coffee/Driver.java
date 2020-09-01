package com.machine.vending.coffee;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.VendingMachineRepository;
import com.machine.vending.coffee.service.VendingMachineService;
import com.machine.vending.coffee.service.VendingMachineServiceImpl;

import java.util.Scanner;

public class Driver {

    private static final String INVALID = "Invalid option !!!!!";

    public static void main(String[] args) throws BeverageNotFoundException {

        Scanner scanner = new Scanner(System.in);

        VendingMachineRepository vendingMachineRepository = new VendingMachineRepository();
        VendingMachineService vendingMachineService = new VendingMachineServiceImpl(vendingMachineRepository);
        VendingMachineOrchestrator vendingMachineOrchestrator = new VendingMachineOrchestrator(vendingMachineService);

        for (int i = 0; i < Ingredient.IngredientMetadata.values().length; i++) {
            vendingMachineOrchestrator.stockUp(Ingredient.IngredientMetadata.values()[i].getId(), 300);
        }

        while (true) {

            System.out.println("1. Load MenuItem");
            System.out.println("2. Load Stock");
            System.out.println("3. Exit");
            int selectedOption = scanner.nextInt();

            if (selectedOption == 1) {
                System.out.println(vendingMachineOrchestrator.getMenu());
                System.out.print("Choose Beverage: ");
                int selectedBeverage = scanner.nextInt();

                if (vendingMachineService.isValidBeverage(selectedBeverage)) {
                    vendingMachineOrchestrator.dispenseBeverage(selectedBeverage);
                } else {
                    System.out.println(INVALID);
                }

            } else if (selectedOption == 2) {

                System.out.println(vendingMachineOrchestrator.getStock());
                System.out.println("R Refill");
                System.out.println("Q Quit");
                System.out.println("M Main MenuItem");

                String selected = scanner.next();

                if (selected.equalsIgnoreCase("r")) {

                    int selectedIngredient = scanner.nextInt();
                    double topUpQuantity = scanner.nextDouble();

                    double updatedStock = vendingMachineOrchestrator.stockUp(selectedIngredient, topUpQuantity);

                    System.out.println("Updated Stock : " + Ingredient.IngredientMetadata.getName(selectedIngredient) + " >>> " + updatedStock);

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
