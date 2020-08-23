package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class Water extends Ingredient {

    public Water(double quantity) {
        super(IngredientEnum.WATER, quantity);
    }
}
