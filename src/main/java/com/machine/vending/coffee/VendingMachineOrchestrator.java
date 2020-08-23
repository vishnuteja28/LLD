package com.machine.vending.coffee;

import com.machine.vending.coffee.enums.IngredientEnum;
import com.machine.vending.coffee.enums.MenuItems;
import com.machine.vending.coffee.service.VendingMachineService;
import com.machine.vending.coffee.service.VendingMachineServiceImpl;

import java.util.Map;

public class VendingMachineOrchestrator {

    private VendingMachineService vendingMachineService;

    public VendingMachineOrchestrator() {
        this.vendingMachineService = VendingMachineServiceImpl.getInstance();
    }

    public String getMenu() {
        MenuItems[] menuItems = vendingMachineService.getMenu();

        StringBuilder fullMenu = new StringBuilder("");
        for (int i = 0; i < menuItems.length; i++) {
            fullMenu.append(menuItems[i].getId() + ". " + menuItems[i].getName()
                    /*+ "  " + menuItems[i].getPrice()*/);
            fullMenu.append("\n");
        }
        return fullMenu.toString();
    }

    public String getStock() {
        Map<Integer, Double> ingredientMap = vendingMachineService.getStock();

        StringBuilder fullIngredients = new StringBuilder("");
        for (Map.Entry<Integer, Double> entry : ingredientMap.entrySet()) {
            fullIngredients.append(entry.getKey() + ". " + getIngredientName(entry.getKey()) +
                    "  >>> Quantity rem: " + entry.getValue());

            fullIngredients.append("\n");
        }
        return fullIngredients.toString();
    }

    public void dispenseBeverage(int beverageId) {

        boolean isAvailable = vendingMachineService.dispenseBeverage(beverageId);
        if (isAvailable) {
            System.out.println("***** Dispensing.... *****");
        } else {
            System.out.println("***** Out of stock !!!! *****");
        }
    }

    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachineService.stockUp(selectedIngredient, topUpQuantity);
    }

    private String getIngredientName(int ingredientId) {
        return IngredientEnum.getName(ingredientId);
    }
}
