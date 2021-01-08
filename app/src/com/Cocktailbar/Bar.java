package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;
import com.Cocktailbar.Exceptions.OutOfStock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Represents a cocktail-bar.
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1.0
 */
public class Bar
{
    private final Menu menu;
    private final Storage storage;

    public Bar(Menu menu, Storage storage)
    {
        this.storage = storage;
        this.menu = menu;
    }

    public Bar(Storage storage)
    {
        this.storage = storage;
        this.menu = new Menu(new ArrayList<>());
    }

    public Bar()
    {
        this.menu = new Menu(new ArrayList<>());
        this.storage = new Storage();
    }

    public Menu getMenu()
    {
        return menu;
    }

    public Storage getStorage()
    {
        return this.storage;
    }

    public void addMenuItem(MenuItem menuItem)
    {
        this.menu.addMenuItem(menuItem);
    }

    public String menuDetails()
    {
        StringBuilder sb = new StringBuilder();
        for (var menuItem : menu.getMenuItems())
            appendMenuItem(sb, menuItem).append("\n");
        return sb.toString();
    }

    private StringBuilder appendMenuItem(StringBuilder sb, MenuItem menuItem)
    {
        sb.append(menuItem.getName()).append(" - Prijs: ").append(menuItem.getPrice()).append("\n");
        if (menuItem instanceof MenuCocktail)
            appendMenuCocktail(sb, (MenuCocktail) menuItem);
        return sb;
    }

    private void appendMenuCocktail(StringBuilder sb, MenuCocktail menuItem)
    {
        sb.append("Ingrediënten:").append("\n");
        for (var ingredient : menuItem.getIngredients())
            sb.append("- ").append(ingredient).append("\n");
    }

    public double paymentAmount(HashSet<Order> orders) throws MenuItemNotFound
    {
        var paymentAmount = 0d;
        for (var order : orders)
            paymentAmount += paymentAmount(order);
        return paymentAmount;
    }

    public double paymentAmount(Order order) throws MenuItemNotFound
    {
        var paymentAmount = 0d;
        for (var cocktailOrder : order.getCocktailOrders().entrySet())
            paymentAmount += getPaymentAmount(cocktailOrder);
        return paymentAmount;
    }

    private double getPaymentAmount(java.util.Map.Entry<CocktailOrder, Integer> cocktailOrder) throws MenuItemNotFound
    {
        var cocktailOrderAmount = 0d;
        cocktailOrderAmount += menu.getByName(cocktailOrder.getKey().getGlass()).getPrice();
        cocktailOrderAmount += menu.getByName(cocktailOrder.getKey().getCocktail()).getPrice();
        for (var addon : cocktailOrder.getKey().getAddons())
            cocktailOrderAmount += menu.getByName(addon).getPrice();
        return cocktailOrderAmount * cocktailOrder.getValue();
    }

    public HashMap<Cocktail, Integer> order(HashSet<Order> orders) throws OutOfStock, MenuItemNotFound
    {
        var cocktails = new HashMap<Cocktail, Integer>();

        for (var order : orders)
        {
            for (var entry : order.getCocktailOrders().entrySet())
            {
                var cocktailOrder = entry.getKey();

                MenuCocktail menuCocktail;
                try
                {
                    menuCocktail = (MenuCocktail) menu.getByName(cocktailOrder.getCocktail());
                }
                catch (Exception e)
                {
                    throw new MenuItemNotFound(cocktailOrder.getCocktail());
                }

                if (!storage.getGlass(cocktailOrder.getGlass(), 1))
                    throw new OutOfStock(cocktailOrder.getGlass());

                var cocktail = new Cocktail(menuCocktail.getName(), cocktailOrder.getGlass());

                for (var ingredient : menuCocktail.getIngredients())
                    if (storage.getIngredient(ingredient, 1))
                        cocktail.addIngredient(ingredient);
                    else
                        throw new OutOfStock(ingredient);

                for (var addon : cocktailOrder.getAddons())
                    if (storage.getAddon(addon, 1))
                        cocktail.addAddon(addon);
                    else
                        throw new OutOfStock(addon);

                cocktails.put(cocktail, entry.getValue());
            }
        }

        return cocktails;
    }
}