package com.machine.vending.coffee;

import com.machine.vending.coffee.enums.BeverageMenuItem;
import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.service.VendingMachine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingMachineOrchestrator {

    private VendingMachine vendingMachine;

    public VendingMachineOrchestrator(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public String getMenu() {
        List<BeverageMenuItem> beverageMenuItemList = vendingMachine.getMenu();

        StringBuilder fullMenu = new StringBuilder("");
        for (int i = 0; i < beverageMenuItemList.size(); i++) {
            fullMenu.append(beverageMenuItemList.get(i).getId() + ". " + beverageMenuItemList.get(i).getName()
                    + "  " + beverageMenuItemList.get(i).getPrice());
            fullMenu.append("\n");
        }
        return fullMenu.toString();
    }

    public String getStock() {

        List<Ingredient> ingredients = vendingMachine.getStock();
        Collections.sort(ingredients, Comparator.comparing(a -> a.getIngredientMetadata().getName()));

        StringBuilder fullIngredients = new StringBuilder("");
        for (Ingredient ingredient : ingredients) {
            fullIngredients.append(ingredient.getIngredientMetadata().getId() + ". " + ingredient.getIngredientMetadata().getName() +
                    "  >>> Quantity rem: " + ingredient.getQuantity());
            fullIngredients.append("\n");
        }

        return fullIngredients.toString();
    }

    public void dispenseBeverage(int beverageId) throws BeverageNotFoundException {

        boolean isAvailable = vendingMachine.dispenseBeverage(beverageId);
        if (isAvailable) {
            System.out.println("***** Dispensing: " + BeverageMenuItem.getName(beverageId) + " .... *****");
        } else {
            System.out.println("***** Out of stock !!!! *****");
        }
    }

    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachine.stockUp(selectedIngredient, topUpQuantity);
    }
}
