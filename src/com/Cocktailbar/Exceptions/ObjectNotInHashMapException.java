package com.Cocktailbar.Exceptions;

public class ObjectNotInHashMapException extends Exception
{
    public ObjectNotInHashMapException()
    {
        super("Object is not in the hashmap");
    }
}
