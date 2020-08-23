package com.machine.vending.coffee.models;

import com.machine.vending.coffee.enums.IngredientEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Ingredient {

    private IngredientEnum ingredientEnum;
    private double quantity;
}
