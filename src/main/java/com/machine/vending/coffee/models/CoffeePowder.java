package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class CoffeePowder extends Ingredient {

    public CoffeePowder(double quantity) {
        super(IngredientEnum.COFFEE_POWDER, quantity);
    }
}
