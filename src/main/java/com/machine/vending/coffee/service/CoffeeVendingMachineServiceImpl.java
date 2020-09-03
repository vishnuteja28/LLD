package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItem;
import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.exceptions.InsufficientIngredientsException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.repository.CoffeeVendingMachineRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoffeeVendingMachineServiceImpl implements CoffeeVendingMachine {

    private CoffeeVendingMachineRepository coffeeVendingMachineRepository;

    public CoffeeVendingMachineServiceImpl(final CoffeeVendingMachineRepository coffeeVendingMachineRepository) {
        this.coffeeVendingMachineRepository = coffeeVendingMachineRepository;
    }

    @Override
    public List<MenuItem> getMenu() {
        List<MenuItem> menuItemList = Arrays.asList(MenuItem.values());
        Collections.sort(menuItemList, Comparator.comparing(MenuItem::getName));
        return menuItemList;
    }

    @Override
    public List<Ingredient> getStock() {
        return coffeeVendingMachineRepository.getStock();
    }

    @Override
    public void dispenseBeverage(int beverageId) throws BeverageNotFoundException, InsufficientIngredientsException {

        MenuItem beverageToPrepare = getMenu().stream().filter(m -> m.getId() == beverageId).findAny().orElse(null);

        if (beverageToPrepare == null) {
            throw new BeverageNotFoundException("Beverage with id: " + beverageId + " not found !!!");
        }

        if (!canBeverageBeDispensed(beverageId)) {
            throw new InsufficientIngredientsException("Beverage with id : " + beverageId + " can't be dispensed as there are insufficient ingredients");
        }

        beverageToPrepare.getIngredients().stream().forEach(ingredient -> {

            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            coffeeVendingMachineRepository.updateStock(ingredientId, -1 * quantityNeeded);
        });
    }

    @Override
    public double updateStock(int selectedIngredientId, double topUpQuantity) throws IngredientNotFoundException {

        Ingredient.IngredientMetadata ingredient = Arrays.asList(Ingredient.IngredientMetadata.values()).stream()
                .filter(i -> i.getId() == selectedIngredientId).findAny().orElse(null);

        if (ingredient == null) {
            throw new IngredientNotFoundException("Ingredient with id : " + selectedIngredientId + " not found");
        }
        return coffeeVendingMachineRepository.updateStock(selectedIngredientId, topUpQuantity);
    }

    private boolean canBeverageBeDispensed(int beverageId) {

        MenuItem beverageToPrepare = getMenu().stream().filter(m -> m.getId() == beverageId).findAny().orElse(null);

        for (Ingredient ingredient : beverageToPrepare.getIngredients()) {
            int ingredientId = ingredient.getIngredientMetadata().getId();
            double quantityNeeded = ingredient.getQuantity();

            if (!coffeeVendingMachineRepository.ingredientAvailable(ingredientId, quantityNeeded)) {
                return false;
            }
        }
        return true;
    }

}
