package com.Cocktailbar.Exceptions;

public class NotEnoughProductsException extends Exception
{
    public NotEnoughProductsException()
    {
        super("Not enough products are in the storage to execute this order");
    }
}
