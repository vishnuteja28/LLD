package com.machine.vending.coffee;

import com.machine.vending.coffee.dto.IngredientDto;
import com.machine.vending.coffee.enums.Menu;
import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.service.VendingMachineService;
import com.machine.vending.coffee.service.VendingMachineServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class VendingMachineOrchestrator {

    private VendingMachineService vendingMachineService;

    public VendingMachineOrchestrator() {
        this.vendingMachineService = VendingMachineServiceImpl.getInstance();
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
        Map<Integer, Double> ingredientMap = vendingMachineService.getStock();

        List<IngredientDto> ingredientDtos = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : ingredientMap.entrySet()) {
            IngredientDto ingredientDto = new IngredientDto(entry.getKey(), Ingredient.IngredientMetadata.getName(entry.getKey()), entry.getValue());
            ingredientDtos.add(ingredientDto);
        }

        Collections.sort(ingredientDtos, Comparator.comparing(IngredientDto::getName));

        StringBuilder fullIngredients = new StringBuilder("");
        for (IngredientDto ingredientDto : ingredientDtos) {
            fullIngredients.append(ingredientDto.getId() + ". " + ingredientDto.getName() +
                    "  >>> Quantity rem: " + ingredientDto.getQuantityRemaining());
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
