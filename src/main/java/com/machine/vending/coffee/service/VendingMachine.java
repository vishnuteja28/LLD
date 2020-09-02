package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.BeverageMenuItem;
import com.machine.vending.coffee.models.Ingredient;

import java.util.List;

public interface VendingMachine {

    List<Ingredient> getStock();

    List<BeverageMenuItem> getMenu();

    boolean dispenseBeverage(int beverageId);

    boolean canBeverageBeDispensed(int beverageId);

    double stockUp(int selectedIngredient, double topUpQuantity);

    boolean isValidBeverage(int beverageId);
}
