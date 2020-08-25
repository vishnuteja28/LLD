package com.machine.vending.coffee.models;

import lombok.Setter;

@Setter
public class Sugar extends Ingredient {

    public Sugar() {
        super(IngredientMetadata.SUGAR);
    }

    public Sugar(double quantity) {
        super(IngredientMetadata.SUGAR, quantity);
    }
}
