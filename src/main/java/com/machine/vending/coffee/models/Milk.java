package com.machine.vending.coffee.models;

import lombok.Setter;

@Setter
public class Milk extends Ingredient {

    public Milk() {
        super(IngredientMetadata.MILK);
    }

    public Milk(double quantity) {
        super(IngredientMetadata.MILK, quantity);
    }
}
