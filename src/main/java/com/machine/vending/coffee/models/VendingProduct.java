package com.machine.vending.coffee.models;

import java.util.List;

public abstract class VendingProduct {

    private int id;
    private String name;
    private double price;
    private List<Ingredient> ingredients;
}
