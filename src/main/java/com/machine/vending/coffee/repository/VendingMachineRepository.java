package com.machine.vending.coffee.repository;

import com.machine.vending.coffee.enums.IngredientEnum;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineRepository {

    private static VendingMachineRepository vendingMachineRepository;
    //key: ingredient id, value: quantityLeft
    private Map<Integer, Double> ingredientHashMap; // stock of ingredients

    public VendingMachineRepository() { //initialize all ingredients with some quantity
        ingredientHashMap = new HashMap<>();
        for (int i = 0; i < IngredientEnum.values().length; i++) {
            ingredientHashMap.put(IngredientEnum.values()[i].getId(), 10d);
        }
    }

    public static VendingMachineRepository getInstance() {
        if (vendingMachineRepository == null) {
            vendingMachineRepository = new VendingMachineRepository();
        }
        return vendingMachineRepository;
    }

    public Map<Integer, Double> getStock() {
        return ingredientHashMap;
    }

    public double getStock(int ingredientId) {
        return ingredientHashMap.getOrDefault(ingredientId, 0d);
    }

    public double updateStock(int ingredientId, double quantityAdded) {

        double quantity = ingredientHashMap.getOrDefault(ingredientId, 0d);
        ingredientHashMap.put(ingredientId, quantity + quantityAdded);
        return quantity + quantityAdded;
    }

    public boolean ingredientAvailable(int ingredientId, double quantityNeeded) {
        return ingredientHashMap.getOrDefault(ingredientId, 0d) >= quantityNeeded;
    }
}
