package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class Milk extends Ingredient {

    public Milk(double quantity) {
        super(IngredientMetadata.MILK, quantity);
    }
}
