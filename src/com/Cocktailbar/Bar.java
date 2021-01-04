package com.Cocktailbar;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a cocktail-bar.
 *
 * @author 4753046
 * @version 0.1
 */
public class Bar
{
    private final Menu menu;

    public Bar(Menu menu)
    {
        this.menu = menu;
    }

    public Bar()
    {
        this.menu = new Menu(new ArrayList<>());
    }

    public Menu getMenu()
    {
        return menu;
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

    private StringBuilder appendMenuCocktail(StringBuilder sb, MenuCocktail menuItem)
    {
        var menuCocktail = menuItem;
        sb.append("Ingrediënten:").append("\n");
        for (var ingredient : menuCocktail.getIngredients())
            sb.append("- ").append(ingredient).append("\n");
        return sb;
    }

    public double paymentAmount(HashSet<Order> orders) throws Menu.MenuItemNotFound
    {
        var paymentAmount = 0d;
        for (var order : orders)
            paymentAmount += paymentAmount(order);
        return paymentAmount;
    }

    public double paymentAmount(Order order) throws Menu.MenuItemNotFound
    {
        var paymentAmount = 0d;
        for (var cocktailOrder : order.getCocktailOrders().entrySet())
            paymentAmount += getPaymentAmount(cocktailOrder);
        return paymentAmount;
    }

    private double getPaymentAmount(java.util.Map.Entry<CocktailOrder, Integer> cocktailOrder) throws Menu.MenuItemNotFound
    {
        var cocktailOrderAmount = 0d;
        cocktailOrderAmount += menu.getByName(cocktailOrder.getKey().getGlass()).getPrice();
        cocktailOrderAmount += menu.getByName(cocktailOrder.getKey().getCocktail()).getPrice();
        for (var addon : cocktailOrder.getKey().getAddons())
            cocktailOrderAmount += menu.getByName(addon).getPrice();
        return cocktailOrderAmount * cocktailOrder.getValue();
    }
}