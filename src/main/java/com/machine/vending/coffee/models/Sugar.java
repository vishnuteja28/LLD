package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class Sugar extends Ingredient {

    public Sugar(double quantity) {
        super(IngredientEnum.SUGAR, quantity);
    }
}
