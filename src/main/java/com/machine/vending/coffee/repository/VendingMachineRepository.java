package com.machine.vending.coffee.repository;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineRepository {

    private static VendingMachineRepository vendingMachineRepository;
    private Map<Integer, Double> ingredientHashMap; //key: ingredient id, value: quantityLeft

    public VendingMachineRepository() { //initialize all ingredients with some quantity
        ingredientHashMap = new HashMap<>();
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

    public double updateStock(int ingredientId, double quantityAdded) {

        double quantity = ingredientHashMap.getOrDefault(ingredientId, 0d);
        ingredientHashMap.put(ingredientId, quantity + quantityAdded);
        return quantity + quantityAdded;
    }

    public boolean ingredientAvailable(int ingredientId, double quantityNeeded) {
        return ingredientHashMap.getOrDefault(ingredientId, 0d) >= quantityNeeded;
    }
}
