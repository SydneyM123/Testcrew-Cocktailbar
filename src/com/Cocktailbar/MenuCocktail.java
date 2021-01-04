package com.Cocktailbar;

import java.util.ArrayList;

/**
 * Represents a cocktail on the menu.
 *
 * @author 4753046
 * @version 0.1
 */
public class MenuCocktail extends MenuItem
{
    private ArrayList<String> ingredients;

    public MenuCocktail(String name, double price)
    {
        super(name, price);
        ingredients = new ArrayList<>();
    }

    public MenuCocktail(String name, double price, ArrayList<String> ingredients)
    {
        super(name, price);
        this.ingredients = ingredients;
    }

    public ArrayList<String> getIngredients()
    {
        return ingredients;
    }

    public void addIngredient(String ingredient)
    {
        ingredients.add(ingredient);
    }
}