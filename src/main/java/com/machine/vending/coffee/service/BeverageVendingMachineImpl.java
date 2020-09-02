package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.BeverageMenuItem;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.VendingMachine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BeverageVendingMachineImpl implements BeverageVendingMachine {

    private VendingMachine vendingMachine;

    public BeverageVendingMachineImpl(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public List<BeverageMenuItem> getMenu() {
        List<BeverageMenuItem> beverageMenuItemList = Arrays.asList(BeverageMenuItem.values());
        Collections.sort(beverageMenuItemList, Comparator.comparing(BeverageMenuItem::getName));
        return beverageMenuItemList;
    }

    @Override
    public List<Ingredient> getStock() {
        return vendingMachine.getStock();
    }

    @Override
    public boolean dispenseBeverage(int beverageId) {

        if (!canBeverageBeDispensed(beverageId)) {
            return false;
        }

        BeverageMenuItem beverageToPrepare = null;
        for (BeverageMenuItem beverageMenuItem : getMenu()) {
            if (beverageMenuItem.getId() == beverageId) {
                beverageToPrepare = beverageMenuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            vendingMachine.updateStock(ingredientId, -1 * quantityNeeded);
        }
        return true;
    }

    @Override
    public double stockUp(int selectedIngredient, double topUpQuantity) {
        return vendingMachine.updateStock(selectedIngredient, topUpQuantity);
    }

    @Override
    public boolean canBeverageBeDispensed(int beverageId) {

        BeverageMenuItem beverageToPrepare = null;
        for (BeverageMenuItem beverageMenuItem : getMenu()) {
            if (beverageMenuItem.getId() == beverageId) {
                beverageToPrepare = beverageMenuItem;
                break;
            }
        }

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            if (!vendingMachine.ingredientAvailable(ingredientId, quantityNeeded)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidBeverage(int beverageId) {

        for (BeverageMenuItem beverageMenuItem : BeverageMenuItem.values()) {
            if (beverageMenuItem.getId() == beverageId) {
                return true;
            }
        }
        return false;
    }
}
