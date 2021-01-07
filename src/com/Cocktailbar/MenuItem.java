package com.Cocktailbar;

/**
 * Represents an item on the menu
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1.0
 */
public class MenuItem
{
    private final String name;
    private final double price;

    public MenuItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}