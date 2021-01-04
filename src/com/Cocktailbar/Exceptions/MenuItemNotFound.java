package com.Cocktailbar.Exceptions;

public class MenuItemNotFound extends Exception
{
    public MenuItemNotFound(String name)
    {
        super("Menu item: " + name);
    }
}