package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class TeaPowder extends Ingredient {

    public TeaPowder(double quantity) {
        super(IngredientEnum.TEA_POWDER, quantity);
    }
}
