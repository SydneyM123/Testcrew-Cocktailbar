package Cocktailbar;

import java.util.ArrayList;

/**
 * Represents a menu of the cocktail-bar.
 *
 * @author 4753046
 * @version 0.1
 */
public class Menu
{
    private ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }

    public ArrayList<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem)
    {
        this.menuItems.add(menuItem);
    }
}