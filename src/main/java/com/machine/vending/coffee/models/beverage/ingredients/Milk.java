package com.machine.vending.coffee.models.beverage.ingredients;

import lombok.Setter;

@Setter
public class Milk extends BeverageIngredient {

    public Milk() {
        super(BeverageIngredientMetadata.MILK);
    }

    public Milk(double quantity) {
        super(BeverageIngredientMetadata.MILK, quantity);
    }
}
