package com.machine.vending.coffee.models.beverage.ingredients;

import lombok.Setter;

@Setter
public class CoffeePowder extends BeverageIngredient {

    public CoffeePowder() {
        super(BeverageIngredientMetadata.COFFEE_POWDER);
    }

    public CoffeePowder(double quantity) {
        super(BeverageIngredientMetadata.COFFEE_POWDER, quantity);
    }
}
