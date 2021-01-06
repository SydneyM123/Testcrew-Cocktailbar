package com.Cocktailbar.Exceptions;

public class OutOfStock extends Exception
{
    public OutOfStock(String item)
    {
        super("The following item is out of stock: " + item);
    }
}