package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.Menu;

import java.util.List;
import java.util.Map;

public interface VendingMachineService {

    Map<Integer, Double> getStock();

    List<Menu> getMenu();

    boolean dispenseBeverage(int beverageId);

    boolean canBeverageBeDispensed(int beverageId);

    double stockUp(int selectedIngredient, double topUpQuantity);
}
