package com.machine.vending.coffee.service;

import com.machine.vending.coffee.enums.MenuItem;
import com.machine.vending.coffee.models.Ingredient;

import java.util.List;

public interface VendingMachine {

    List<Ingredient> getStock();

    List<MenuItem> getMenu();

}
