package com.machine.vending.coffee.factory;

import com.machine.vending.coffee.models.ChocolatePowder;
import com.machine.vending.coffee.models.CoffeePowder;
import com.machine.vending.coffee.models.Cream;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.models.Milk;
import com.machine.vending.coffee.models.Sugar;
import com.machine.vending.coffee.models.TeaPowder;
import com.machine.vending.coffee.models.Water;

import java.util.ArrayList;
import java.util.List;

public class IngredientFactory {

    public static List<Ingredient> getIngredients(int beverageId) {

        List<Ingredient> ingredients = new ArrayList<>();

        //1 unit = 10gms or 10ml
        switch (beverageId) {
            case 1: //coffee
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(5));
                ingredients.add(new CoffeePowder(2));
                ingredients.add(new Cream(1));
                break;
            case 2: //chocolate milk
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(5));
                ingredients.add(new ChocolatePowder(2));
                ingredients.add(new Water(1));
                break;
            case 3: // hot milk
                ingredients.add(new Milk(10));
                break;
            case 4: //hot water
                ingredients.add(new Water(10));
                break;
            case 5: //tea
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(3));
                ingredients.add(new TeaPowder(2));
                ingredients.add(new Water(3));
                break;
            case 6: //iced tea
                ingredients.add(new Sugar(2));
                ingredients.add(new TeaPowder(2));
                ingredients.add(new Water(6));
                break;
            default:
        }
        return ingredients;
    }

    public static Ingredient getIngredientType(int ingredientId) {

        switch (ingredientId) {
            case 1: //sugar
                return new Sugar();
            case 2: //coffee
                return new CoffeePowder();
            case 3: // water
                return new Water();
            case 4: //tea
                return new TeaPowder();
            case 5: //chocolate
                return new ChocolatePowder();
            case 6: //milk
                return new Milk();
            case 7: //cream
                return new Cream();
            default:
                return null;
        }
    }
}
