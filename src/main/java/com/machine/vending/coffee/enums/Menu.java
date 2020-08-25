package com.machine.vending.coffee.enums;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.factory.IngredientFactory;
import com.machine.vending.coffee.models.Ingredient;
import lombok.Getter;

import java.util.List;

@Getter
public enum Menu {

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

    Menu(int id, String name) {
        this.id = id;
        this.name = name;
        try {
            this.ingredients = IngredientFactory.getIngredients(id);
        } catch (BeverageNotFoundException e) {
            e.printStackTrace();
        }
        this.price = calculatePrice(ingredients);
    }

    public static String getName(int beverageId) throws BeverageNotFoundException {
        for (Menu menu : Menu.values()) {
            if (menu.getId() == beverageId) {
                return menu.getName();
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
