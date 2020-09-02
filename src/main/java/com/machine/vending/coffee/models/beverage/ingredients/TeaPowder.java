package com.machine.vending.coffee.models.beverage.ingredients;

import com.machine.vending.coffee.models.Ingredient;
import lombok.Setter;

@Setter
public class TeaPowder extends BeverageIngredient {

    public TeaPowder() {
        super(BeverageIngredientMetadata.TEA_POWDER);
    }

    public TeaPowder(double quantity) {
        super(BeverageIngredientMetadata.TEA_POWDER, quantity);
    }
}
