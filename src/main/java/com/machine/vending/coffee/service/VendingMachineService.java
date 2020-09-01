package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItem;
import com.machine.vending.coffee.models.Ingredient;

import java.util.List;

public interface VendingMachineService {

    List<Ingredient> getStock();

    List<MenuItem> getMenu();

    boolean dispenseBeverage(int beverageId);

    boolean canBeverageBeDispensed(int beverageId);

    double stockUp(int selectedIngredient, double topUpQuantity);

    boolean isValidBeverage(int beverageId);
}
