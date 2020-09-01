package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItem;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.VendingMachineRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineRepository vendingMachineRepository;

    public VendingMachineServiceImpl(final VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public List<MenuItem> getMenu() {
        List<MenuItem> menuItemList = Arrays.asList(MenuItem.values());
        Collections.sort(menuItemList, Comparator.comparing(MenuItem::getName));
        return menuItemList;
    }

    @Override
    public List<Ingredient> getStock() {
        return vendingMachineRepository.getStock();
    }

    @Override
    public boolean dispenseBeverage(int beverageId) {

        if (!canBeverageBeDispensed(beverageId)) {
            return false;
        }

        MenuItem beverageToPrepare = null;
        for (MenuItem menuItem : getMenu()) {
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

    @Override
    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachineRepository.updateStock(selectedIngredient, topUpQuantity);
    }

    @Override
    public boolean canBeverageBeDispensed(int beverageId) {

        MenuItem beverageToPrepare = null;
        for (MenuItem menuItem : getMenu()) {
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

    @Override
    public boolean isValidBeverage(int beverageId) {

        for (MenuItem menuItem : MenuItem.values()) {
            if (menuItem.getId() == beverageId) {
                return true;
            }
        }
        return false;
    }
}
