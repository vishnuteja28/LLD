package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.Getter;

@Getter
public class ChocolatePowder extends Ingredient {

    public ChocolatePowder(double quantity) {
        super(IngredientEnum.CHOCOLATE_POWDER, quantity);
    }
}
