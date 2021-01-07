package com.Cocktailbar.Exceptions;

/**
 * Throws an exception when a menu item is not found
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1
 */
public class MenuItemNotFound extends Exception
{
    public MenuItemNotFound(String name)
    {
        super("Menu item: " + name);
    }
}