package com.machine.vending.coffee.models.beverage.ingredients;

import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public abstract class BeverageIngredient extends Ingredient {

    private BeverageIngredientMetadata beverageIngredientMetadata;

    public BeverageIngredient(BeverageIngredientMetadata beverageIngredientMetadata) {
        this.beverageIngredientMetadata = beverageIngredientMetadata;
    }

    public BeverageIngredient(BeverageIngredientMetadata beverageIngredientMetadata, double quantity) {
        super(quantity);
        this.beverageIngredientMetadata = beverageIngredientMetadata;
    }

    @Getter
    @AllArgsConstructor
    public enum BeverageIngredientMetadata {

        SUGAR(1, "Sugar", 5),
        COFFEE_POWDER(2, "Coffee Powder", 25),
        WATER(3, "Water", 1),
        TEA_POWDER(4, "Tea Powder", 20),
        CHOCOLATE_POWDER(5, "Chocolate Powder", 30),
        MILK(6, "Milk", 10),
        CREAM(7, "Cream", 10);

        private int id;
        private String name;
        private double price; // 1 unit price , 1 unit = 10gms or 10ml

        public static String getName(int id) throws IngredientNotFoundException {
            for (BeverageIngredientMetadata ingredientMetadata : BeverageIngredientMetadata.values()) {
                if (ingredientMetadata.getId() == id) {
                    return ingredientMetadata.getName();
                }
            }
            throw new IngredientNotFoundException("Ingredient with id : " + id + " not found");
        }
    }
}
