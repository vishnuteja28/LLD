package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.Menu;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.VendingMachineRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingMachineServiceImpl implements VendingMachineService {

    private static VendingMachineService vendingMachineService;
    private VendingMachineRepository vendingMachineRepository;

    private VendingMachineServiceImpl() {
        vendingMachineRepository = VendingMachineRepository.getInstance();
    }

    public static VendingMachineService getInstance() {
        if (vendingMachineService == null) {
            vendingMachineService = new VendingMachineServiceImpl();
        }
        return vendingMachineService;
    }

    public List<Menu> getMenu() {
        List<Menu> menuList = Arrays.asList(Menu.values());
        Collections.sort(menuList, Comparator.comparing(Menu::getName));
        return menuList;
    }

    public List<Ingredient> getStock() {
        return vendingMachineRepository.getStock();
    }

    public boolean dispenseBeverage(int beverageId) {

        if (!canBeverageBeDispensed(beverageId)) {
            return false;
        }

        Menu beverageToPrepare = null;
        for (Menu menuItem : getMenu()) {
            if (menuItem.getId() == beverageId) {
                beverageToPrepare = menuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            vendingMachineRepository.updateStock(ingredientId, -1 * quantityNeeded);
        }
        return true;
    }

    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachineRepository.updateStock(selectedIngredient, topUpQuantity);
    }

    public boolean canBeverageBeDispensed(int beverageId) {

        Menu beverageToPrepare = null;
        for (Menu menuItem : getMenu()) {
            if (menuItem.getId() == beverageId) {
                beverageToPrepare = menuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            if (!vendingMachineRepository.ingredientAvailable(ingredientId, quantityNeeded)) {
                return false;
            }
        }
        return true;
    }
}
