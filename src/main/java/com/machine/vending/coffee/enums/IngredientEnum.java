package com.machine.vending.coffee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IngredientEnum {

    SUGAR(1, "Sugar"),
    COFFEE_POWDER(2, "Coffee Powder"),
    WATER(3, "Water"),
    TEA_POWDER(4, "Tea Powder"),
    CHOCOLATE_POWDER(5, "Chocolate Powder"),
    MILK(6, "Milk");

    private int id;
    private String name;

    public static String getName(int id) {
        for (IngredientEnum ingredientEnum : IngredientEnum.values()) {
            if (ingredientEnum.getId() == id) {
                return ingredientEnum.getName();
            }
        }
        return null;
    }
}
