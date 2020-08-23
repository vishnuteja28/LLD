package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItems;

import java.util.Map;

public interface VendingMachineService {

    Map<Integer, Double> getStock();

    MenuItems[] getMenu();

    boolean dispenseBeverage(int beverageId);

    boolean canBeverageBeDispensed(int beverageId);

    double stockUp(int selectedIngredient, double topUpQuantity);
}
