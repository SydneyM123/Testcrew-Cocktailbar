package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;

import java.util.ArrayList;

/**
 * Represents a menu of the cocktail-bar.
 *
 * @author 4753046
 * @version 0.1
 */
public class Menu
{
    private final ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }

    public Menu()
    {
        this.menuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public MenuItem getByName(String name) throws MenuItemNotFound
    {
        MenuItem menuItem = null;

        for (var item : menuItems)
            if (item.getName().equals(name))
                menuItem = item;

        if (menuItem == null)
            throw new MenuItemNotFound(name);

        return menuItem;
    }

    public void addMenuItem(MenuItem menuItem)
    {
        this.menuItems.add(menuItem);
    }
}