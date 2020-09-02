package com.machine.vending.coffee.models.beverage.ingredients;

import com.machine.vending.coffee.models.Ingredient;
import lombok.Setter;

@Setter
public class Sugar extends BeverageIngredient {

    public Sugar() {
        super(BeverageIngredientMetadata.SUGAR);
    }

    public Sugar(double quantity) {
        super(BeverageIngredientMetadata.SUGAR, quantity);
    }
}
