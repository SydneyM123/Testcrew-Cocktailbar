package com.Cocktailbar;

import com.Cocktailbar.Exceptions.OutOfStock;

import java.util.HashMap;

/**
 * Represents the storage of the cocktailbar.
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1.0
 */
public class Storage
{
    private final HashMap<String, Integer> glasses;
    private final HashMap<String, Integer> ingredients;
    private final HashMap<String, Integer> addons;

    public Storage()
    {
        this.glasses = new HashMap<>();
        this.ingredients = new HashMap<>();
        this.addons = new HashMap<>();
    }

    public HashMap<String, Integer> getGlasses()
    {
        return glasses;
    }

    public HashMap<String, Integer> getIngredients()
    {
        return ingredients;
    }

    public HashMap<String, Integer> getAddons()
    {
        return addons;
    }

    public void addGlass(String glass)
    {
        int amount = 1;
        if(glasses.containsKey(glass))
            amount += glasses.get(glass);
        glasses.put(glass, amount);
    }

    public void removeGlass(String glass) throws OutOfStock
    {
        if(glasses.containsKey(glass))
            glasses.remove(glass);
        else
            throw new OutOfStock(glass);
    }

    public void addIngredient(String ingredient)
    {
        int amount = 1;
        if(ingredients.containsKey(ingredient))
            amount += ingredients.get(ingredient);
        ingredients.put(ingredient, amount);
    }

    public void removeIngredient(String ingredient) throws OutOfStock
    {
        if(ingredients.containsKey(ingredient))
            ingredients.remove(ingredient);
        else
            throw new OutOfStock(ingredient);
    }

    public void addAddon(String addon)
    {
        int amount = 1;
        if(addons.containsKey(addon))
            amount += addons.get(addon);
        addons.put(addon, amount);
    }

    public void removeAddon(String addon) throws OutOfStock
    {
        if(addons.containsKey(addon))
            addons.remove(addon);
        else
            throw new OutOfStock(addon);
    }

    public int checkStockIngredient(String ingredient)
    {
        if(this.ingredients.containsKey(ingredient))
            return this.ingredients.get(ingredient);
        return 0;
    }

    public int checkStockGlass(String glass)
    {
        if(this.glasses.containsKey(glass))
            return this.glasses.get(glass);
        return 0;
    }

    public int checkStockAddon(String addon)
    {
        if(this.addons.containsKey(addon))
            return this.addons.get(addon);
        return 0;
    }

    public boolean getGlass(String glass, int amount)
    {
        if(checkStockGlass(glass) >= amount)
        {
            this.glasses.replace(glass, this.glasses.get(glass) - amount);
            return true;
        }
        return false;
    }

    public boolean getIngredient(String ingredient, int amount)
    {
        if(checkStockIngredient(ingredient) >= amount)
        {
            this.ingredients.replace(ingredient, this.ingredients.get(ingredient) - amount);
            return true;
        }
        return false;
    }

    public boolean getAddon(String addon, int amount)
    {
        if(checkStockAddon(addon) >= amount)
        {
            this.addons.replace(addon, this.addons.get(addon) - amount);
            return true;
        }
        return false;
    }
}