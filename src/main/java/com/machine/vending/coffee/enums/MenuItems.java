package com.machine.vending.coffee.enums;

import com.machine.vending.coffee.factory.IngredientFactory;
import com.machine.vending.coffee.models.Ingredient;
import lombok.Getter;

import java.util.List;

@Getter
public enum MenuItems {

    COFFEE(1, "Coffee", 10),
    CHOCOLATE_MILK(2, "Chocolate Milk", 15),
    HOT_MILK(3, "Hot Milk", 5),
    HOT_WATER(4, "Hot Water", 2),
    TEA(5, "Tea", 8),
    ICED_TEA(6, "Iced Tea", 5);

    private int id;
    private String name;
    private double price;
    private List<Ingredient> ingredients;

    MenuItems(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = IngredientFactory.getIngredients(id);
    }
}
