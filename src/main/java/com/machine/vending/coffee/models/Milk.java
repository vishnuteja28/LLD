package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class Milk extends Ingredient {

    public Milk(double quantity) {
        super(IngredientEnum.MILK, quantity);
    }
}
