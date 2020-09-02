package com.machine.vending.coffee.enums;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.factory.BeverageIngredientFactory;
import com.machine.vending.coffee.factory.IngredientFactory;
import com.machine.vending.coffee.models.beverage.ingredients.BeverageIngredient;
import lombok.Getter;

import java.util.List;

@Getter
public enum BeverageMenuItem {

    COFFEE(1, "Coffee"),
    CHOCOLATE_MILK(2, "Chocolate Milk"),
    HOT_MILK(3, "Hot Milk"),
    HOT_WATER(4, "Hot Water"),
    TEA(5, "Tea"),
    ICED_TEA(6, "Iced Tea");

    private int id;
    private String name;
    private double price;
    private List<BeverageIngredient> ingredients;

    BeverageMenuItem(int id, String name) {
        this.id = id;
        this.name = name;
        try {
//            this.ingredients = BeverageIngredientFactory.getIngredients(id);
        } catch (BeverageNotFoundException e) {
            e.printStackTrace();
        }
        this.price = calculatePrice(ingredients);
    }

    public static String getName(int beverageId) throws BeverageNotFoundException {
        for (BeverageMenuItem beverageMenuItem : BeverageMenuItem.values()) {
            if (beverageMenuItem.getId() == beverageId) {
                return beverageMenuItem.getName();
            }
        }
        throw new BeverageNotFoundException("Beverage with id: " + beverageId + " not found");
    }

    private double calculatePrice(List<BeverageIngredient> ingredients) {
        double price = 0d;
        for (BeverageIngredient beverageIngredient : ingredients) {
            price += beverageIngredient.getBeverageIngredientMetadata().getPrice() * beverageIngredient.getQuantity();
        }
        return price;
    }


}
