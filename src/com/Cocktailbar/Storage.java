package com.Cocktailbar;

import com.Cocktailbar.Exceptions.ObjectNotInHashMapException;

import java.util.HashMap;

public class Storage
{
    HashMap<String, Integer> glasses;
    HashMap<String, Integer> ingredients;
    HashMap<String, Integer> addons;

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
        {
            amount += glasses.get(glass);
        }
        glasses.put(glass, amount);
    }

    public void removeGlass(String glass) throws ObjectNotInHashMapException
    {
        if(glasses.containsKey(glass))
        {
            glasses.remove(glass);
        }
        else
        {
            throw new ObjectNotInHashMapException();
        }
    }

    public void addIngredient(String ingredient)
    {
        int amount = 1;
        if(ingredients.containsKey(ingredient))
        {
            amount += ingredients.get(ingredient);
        }
        ingredients.put(ingredient, amount);
    }

    public void removeIngredient(String ingredient) throws ObjectNotInHashMapException
    {
        if(ingredients.containsKey(ingredient))
        {
            ingredients.remove(ingredient);
        }
        else
        {
            throw new ObjectNotInHashMapException();
        }
    }

    public void addAddon(String addon)
    {
        int amount = 1;
        if(addons.containsKey(addon))
        {
            amount += addons.get(addon);
        }
        addons.put(addon, amount);
    }

    public void removeAddon(String addon) throws ObjectNotInHashMapException
    {
        if(addons.containsKey(addon))
        {
            addons.remove(addon);
        }
        else
        {
            throw new ObjectNotInHashMapException();
        }
    }

    public int checkStockIngredient(String ingredient)
    {
        if(this.ingredients.containsKey(ingredient))
        {
            return this.ingredients.get(ingredient);
        }

        return 0;
    }

    public int checkStockGlass(String glass)
    {
        if(this.glasses.containsKey(glass))
        {
            return this.ingredients.get(glass);
        }

        return 0;
    }

    public int checkStockAddon(String addon)
    {
        if(this.addons.containsKey(addon))
        {
            return this.ingredients.get(addon);
        }

        return 0;
    }

}