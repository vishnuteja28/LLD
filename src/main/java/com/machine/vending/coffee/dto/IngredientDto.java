package com.machine.vending.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IngredientDto {

    private int id;
    private String name;
    private double quantityRemaining;
}
