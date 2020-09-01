package com.machine.vending.coffee;

import com.machine.vending.coffee.enums.Menu;
import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.service.VendingMachineService;
import com.machine.vending.coffee.service.VendingMachineServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingMachineOrchestrator {

    private VendingMachineService vendingMachineService;

    public VendingMachineOrchestrator(final VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public String getMenu() {
        List<Menu> menuList = vendingMachineService.getMenu();

        StringBuilder fullMenu = new StringBuilder("");
        for (int i = 0; i < menuList.size(); i++) {
            fullMenu.append(menuList.get(i).getId() + ". " + menuList.get(i).getName()
                    + "  " + menuList.get(i).getPrice());
            fullMenu.append("\n");
        }
        return fullMenu.toString();
    }

    public String getStock() {

        List<Ingredient> ingredients = vendingMachineService.getStock();
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

        boolean isAvailable = vendingMachineService.dispenseBeverage(beverageId);
        if (isAvailable) {
            System.out.println("***** Dispensing: " + Menu.getName(beverageId) + " .... *****");
        } else {
            System.out.println("***** Out of stock !!!! *****");
        }
    }

    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachineService.stockUp(selectedIngredient, topUpQuantity);
    }
}
