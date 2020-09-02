package com.machine.vending.coffee.factory;

import com.machine.vending.coffee.exceptions.BeverageNotFoundException;
import com.machine.vending.coffee.exceptions.IngredientNotFoundException;
import com.machine.vending.coffee.models.Ingredient;
import com.machine.vending.coffee.models.beverage.ingredients.BeverageIngredient;
import com.machine.vending.coffee.models.beverage.ingredients.ChocolatePowder;
import com.machine.vending.coffee.models.beverage.ingredients.CoffeePowder;
import com.machine.vending.coffee.models.beverage.ingredients.Cream;
import com.machine.vending.coffee.models.beverage.ingredients.Milk;
import com.machine.vending.coffee.models.beverage.ingredients.Sugar;
import com.machine.vending.coffee.models.beverage.ingredients.TeaPowder;
import com.machine.vending.coffee.models.beverage.ingredients.Water;

import java.util.ArrayList;
import java.util.List;

public class BeverageIngredientFactory extends IngredientFactory {

    public List<Ingredient> getIngredients(int beverageId) throws BeverageNotFoundException {

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
                throw new BeverageNotFoundException("Beverage with id: " + beverageId + " not found !!!");
        }
        return ingredients;
    }

    public Ingredient getIngredientType(int ingredientId) throws IngredientNotFoundException {

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
                throw new IngredientNotFoundException("Ingredient with id: " + ingredientId + " not found !!!");
        }
    }
}
