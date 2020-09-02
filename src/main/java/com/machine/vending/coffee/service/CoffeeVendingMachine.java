package com.machine.vending.coffee.service;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.exceptions.InsufficientIngredientsException;

public interface CoffeeVendingMachine extends VendingMachine {

    void dispenseBeverage(int beverageId) throws InsufficientIngredientsException, BeverageNotFoundException;

    double updateStock(int selectedIngredient, double topUpQuantity) throws IngredientNotFoundException;
}
