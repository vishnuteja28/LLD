package com.machine.vending.coffee.models;

import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Ingredient {

//        private IngredientMetadata ingredientMetadata;
//    private double price;
    private double quantity;

    public Ingredient(double quantity) {
        this.quantity = quantity;
    }

//    @Getter
//    @AllArgsConstructor
//    public enum IngredientMetadata {
//
//        SUGAR(1, "Sugar", 5),
//        COFFEE_POWDER(2, "Coffee Powder", 25),
//        WATER(3, "Water", 1),
//        TEA_POWDER(4, "Tea Powder", 20),
//        CHOCOLATE_POWDER(5, "Chocolate Powder", 30),
//        MILK(6, "Milk", 10),
//        CREAM(7, "Cream", 10);
//
//        private int id;
//        private String name;
//        private double price; // 1 unit price , 1 unit = 10gms or 10ml
//
//        public static String getName(int id) throws IngredientNotFoundException {
//            for (IngredientMetadata ingredientMetadata : IngredientMetadata.values()) {
//                if (ingredientMetadata.getId() == id) {
//                    return ingredientMetadata.getName();
//                }
//            }
//            throw new IngredientNotFoundException("Ingredient with id : " + id + " not found");
//        }
//    }
}