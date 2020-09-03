package com.machine.vending.coffee;

import com.machine.vending.coffee.enums.MenuItem;
import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.exceptions.InsufficientIngredientsException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.service.CoffeeVendingMachine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoffeeVendingMachineOrchestrator {

    private CoffeeVendingMachine vendingMachine;

    public CoffeeVendingMachineOrchestrator(final CoffeeVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void getMenu() {

        List<MenuItem> menuItemList = vendingMachine.getMenu();

        StringBuilder fullMenu = new StringBuilder("");

        menuItemList.stream().forEach(menuItem -> {
            fullMenu.append(menuItem.getId() + ". " + menuItem.getName()
                    + "  " + menuItem.getPrice());
            fullMenu.append("\n");
        });

        System.out.println(fullMenu.toString());
    }

    public void getStock() {

        List<Ingredient> ingredients = vendingMachine.getStock();
        Collections.sort(ingredients, Comparator.comparing(a -> a.getIngredientMetadata().getName()));

        StringBuilder fullIngredients = new StringBuilder("");

        ingredients.stream().forEach(ingredient -> {
            fullIngredients.append(ingredient.getIngredientMetadata().getId() + ". " + ingredient.getIngredientMetadata().getName() +
                    "  >>> Quantity rem: " + ingredient.getQuantity());
            fullIngredients.append("\n");
        });

        System.out.println(fullIngredients.toString());
    }

    public void dispenseBeverage(int beverageId) {

        try {
            vendingMachine.dispenseBeverage(beverageId);
            System.out.println("***** Dispensing: " + MenuItem.getBeverageName(beverageId) + " .... *****");
        } catch (BeverageNotFoundException e) {
            System.out.println("Beverage with id: " + beverageId + " not found");
        } catch (InsufficientIngredientsException e) {
            System.out.println("Beverage with id: " + beverageId + " CANNOT be dispensed because of insufficient stock of ingredients");
        }
    }

    public void stockUp(int selectedIngredient, double topUpQuantity) {

        try {
            double updatedQuantity = vendingMachine.updateStock(selectedIngredient, topUpQuantity);
            System.out.println("Updated Stock : " + Ingredient.IngredientMetadata.getName(selectedIngredient) + " >>> " + updatedQuantity);
        } catch (IngredientNotFoundException e) {
            System.out.println("Ingredient with id : " + selectedIngredient + " not found");
        }
    }
}
