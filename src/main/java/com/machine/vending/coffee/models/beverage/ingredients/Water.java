package com.machine.vending.coffee.models.beverage.ingredients;

import lombok.Setter;

@Setter
public class Water extends BeverageIngredient {

    public Water() {
        super(BeverageIngredientMetadata.WATER);
    }

    public Water(double quantity) {
        super(BeverageIngredientMetadata.WATER, quantity);
    }
}
