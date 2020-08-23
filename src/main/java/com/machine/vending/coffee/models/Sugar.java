package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class Sugar extends Ingredient {

    public Sugar(double quantity) {
        super(IngredientMetadata.SUGAR, quantity);
    }
}
