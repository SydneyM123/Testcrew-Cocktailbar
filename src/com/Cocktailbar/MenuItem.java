package com.Cocktailbar;

/**
 * Represents an item on the menu
 *
 * @author 4753046
 * @version 0.1
 */
public class MenuItem
{
    private String name;
    private double price;

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