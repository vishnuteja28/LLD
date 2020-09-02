package com.machine.vending.coffee.models.beverage.ingredients;

import lombok.Setter;

@Setter
public class ChocolatePowder extends BeverageIngredient {

    public ChocolatePowder() {
        super(BeverageIngredientMetadata.CHOCOLATE_POWDER);
    }

    public ChocolatePowder(double quantity) {
        super(BeverageIngredientMetadata.CHOCOLATE_POWDER.CHOCOLATE_POWDER, quantity);
    }
}
