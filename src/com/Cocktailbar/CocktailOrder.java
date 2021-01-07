package com.Cocktailbar;

import java.util.HashSet;

/**
 * Represents a cocktail order.
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1
 */
public class CocktailOrder
{
    private String glass;
    private String cocktail;
    private final HashSet<String> addons;

    public CocktailOrder()
    {
        this.glass = "";
        this.cocktail = "";
        this.addons = new HashSet<>();
    }

    public CocktailOrder(String glass, String cocktail)
    {
        this.glass = glass;
        this.cocktail = cocktail;
        this.addons = new HashSet<>();
    }

    public String getGlass()
    {
        return glass;
    }

    public void setGlass(String glass)
    {
        this.glass = glass;
    }

    public String getCocktail()
    {
        return cocktail;
    }

    public void setCocktail(String cocktail)
    {
        this.cocktail = cocktail;
    }

    public HashSet<String> getAddons()
    {
        return addons;
    }

    public void addAddon(String addon)
    {
        this.addons.add(addon);
    }

    public void removeAddon(String addon)
    {
        this.addons.remove(addon);
    }
}