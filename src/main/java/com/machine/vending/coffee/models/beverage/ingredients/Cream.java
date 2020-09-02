package com.machine.vending.coffee.models.beverage.ingredients;

import lombok.Setter;

@Setter
public class Cream extends BeverageIngredient {

    public Cream() {
        super(BeverageIngredientMetadata.CREAM);
    }

    public Cream(double quantity) {

        super(BeverageIngredientMetadata.CREAM, quantity);
    }
}
