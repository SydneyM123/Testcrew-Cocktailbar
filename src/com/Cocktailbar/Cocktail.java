package com.Cocktailbar;

import java.util.HashSet;

/**
 * Represents a cocktail.
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 0.1
 */
public class Cocktail
{
    private String name;
    private String glass;
    private final HashSet<String> addons;
    private final HashSet<String> ingredients;

    public Cocktail(String name, String glass)
    {
        this.name = name;
        this.glass = glass;
        this.addons = new HashSet<>();
        this.ingredients = new HashSet<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGlass()
    {
        return glass;
    }

    public void setGlass(String glass)
    {
        this.glass = glass;
    }

    public void addIngredient(String ingredient)
    {
        ingredients.add(ingredient);
    }

    public void addAddon(String addon)
    {
        addons.add(addon);
    }

    public HashSet<String> getAddons()
    {
        return addons;
    }

    public HashSet<String> getIngredients()
    {
        return ingredients;
    }
}