package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItems;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.VendingMachineRepository;

import java.util.Map;

public class VendingMachineServiceImpl implements VendingMachineService {

    private static VendingMachineService vendingMachineService;
    private VendingMachineRepository vendingMachineRepository;

    public VendingMachineServiceImpl() {
        vendingMachineRepository = VendingMachineRepository.getInstance();
    }

    public static VendingMachineService getInstance() {
        if (vendingMachineService == null) {
            vendingMachineService = new VendingMachineServiceImpl();
        }
        return vendingMachineService;
    }

    public MenuItems[] getMenu() {
        return MenuItems.values();
    }

    public Map<Integer, Double> getStock() {
        return vendingMachineRepository.getStock();
    }

    public boolean dispenseBeverage(int beverageId) {

        if (!canBeverageBeDispensed(beverageId)) {
            return false;
        }

        MenuItems beverageToPrepare = null;
        for (MenuItems menuItem : getMenu()) {
            if (menuItem.getId() == beverageId) {
                beverageToPrepare = menuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientEnum().getId();
            double quantityNeeded = ingredient.getQuantity();

            vendingMachineRepository.updateStock(ingredientId, -1 * quantityNeeded);
        }
        return true;
    }

    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachineRepository.updateStock(selectedIngredient, topUpQuantity);
    }

    public boolean canBeverageBeDispensed(int beverageId) {

        MenuItems beverageToPrepare = null;
        for (MenuItems menuItem : getMenu()) {
            if (menuItem.getId() == beverageId) {
                beverageToPrepare = menuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientEnum().getId();
            double quantityNeeded = ingredient.getQuantity();

            if (!vendingMachineRepository.ingredientAvailable(ingredientId, quantityNeeded)) {
                return false;
            }
        }
        return true;
    }
}