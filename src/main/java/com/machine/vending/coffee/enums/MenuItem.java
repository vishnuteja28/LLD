package com.machine.vending.coffee.enums;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.factory.IngredientFactory;
import com.machine.vending.coffee.models.Ingredient;
import lombok.Getter;

import java.util.List;

@Getter
public enum MenuItem {

    COFFEE(1, "Coffee"),
    CHOCOLATE_MILK(2, "Chocolate Milk"),
    HOT_MILK(3, "Hot Milk"),
    HOT_WATER(4, "Hot Water"),
    TEA(5, "Tea"),
    ICED_TEA(6, "Iced Tea");

    private int id;
    private String name;
    private double price;
    private List<Ingredient> ingredients;

    MenuItem(int id, String name) {
        this.id = id;
        this.name = name;
        this.ingredients = IngredientFactory.getIngredients(id);
        this.price = calculatePrice(ingredients);
    }

    public static String getBeverageName(int beverageId) throws BeverageNotFoundException {
        for (MenuItem menuItem : MenuItem.values()) {
            if (menuItem.getId() == beverageId) {
                return menuItem.getName();
            }
        }
        throw new BeverageNotFoundException("Beverage with id: " + beverageId + " not found");
    }

    private double calculatePrice(List<Ingredient> ingredients) {
        double price = 0d;
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getIngredientMetadata().getPrice() * ingredient.getQuantity();
        }
        return price;
    }


}
