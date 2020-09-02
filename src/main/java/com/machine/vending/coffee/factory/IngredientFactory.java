package com.machine.vending.coffee.factory;

import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.exceptions.MenuItemNotFoundException;
import com.machine.vending.coffee.models.Ingredient;

import java.util.List;

public abstract class IngredientFactory {

    abstract List<Ingredient> getIngredients(int menuItemId) throws MenuItemNotFoundException;

    abstract Ingredient getIngredientType(int ingredientId) throws IngredientNotFoundException;
}
