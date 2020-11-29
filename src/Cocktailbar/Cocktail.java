package Cocktailbar;

import java.util.HashSet;

public class Cocktail
{
    private String name;
    private String glass;
    private HashSet<String> addons;
    private HashSet<String> ingredients;

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

    private void AddIngredient(String ingredient)
    {
        ingredients.add(ingredient);
    }

    private void AddAddon(String addon)
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