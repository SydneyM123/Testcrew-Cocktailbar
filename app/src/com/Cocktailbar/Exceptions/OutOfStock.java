package com.Cocktailbar.Exceptions;

/**
 * Throws an exception when an item is out of stock
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1
 */
public class OutOfStock extends Exception
{
    public OutOfStock(String item)
    {
        super("The following item is out of stock: " + item);
    }
}