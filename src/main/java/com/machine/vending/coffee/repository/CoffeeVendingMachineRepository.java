package com.machine.vending.coffee.repository;

import com.machine.vending.coffee.factory.IngredientFactory;
import com.machine.vending.coffee.models.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeVendingMachineRepository {

    private Map<Integer, Double> ingredientMap; //key: ingredient id, value: quantityLeft

    public CoffeeVendingMachineRepository() {
        ingredientMap = new HashMap<>();
    }

    public List<Ingredient> getStock() {

        List<Ingredient> ingredients = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : ingredientMap.entrySet()) {
            Ingredient ingredient = IngredientFactory.getIngredientType(entry.getKey());
            ingredient.setQuantity(entry.getValue());
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    public double updateStock(int ingredientId, double quantityAdded) {

        double quantity = ingredientMap.getOrDefault(ingredientId, 0d);
        ingredientMap.put(ingredientId, quantity + quantityAdded);
        return quantity + quantityAdded;
    }

    public boolean ingredientAvailable(int ingredientId, double quantityNeeded) {
        return ingredientMap.getOrDefault(ingredientId, 0d) >= quantityNeeded;
    }
}
