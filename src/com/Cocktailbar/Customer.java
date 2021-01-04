package com.Cocktailbar;

import java.util.HashSet;

public class Customer
{
    private String name;
    private HashSet<Order> orders;
    private HashSet<CocktailOrder> favoriteCocktails;

    public Customer(String name)
    {
        this.name = name;
        this.orders = new HashSet<>();
        this.favoriteCocktails = new HashSet<>();
    }

    public String getName()
    {
        return name;
    }

    public HashSet<Order> getOrders()
    {
        return orders;
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public void removeOrder(Order order)
    {
        this.orders.remove(order);
    }

    public HashSet<CocktailOrder> getFavoriteCocktails()
    {
        return favoriteCocktails;
    }

    public void addFavoriteCocktail(CocktailOrder favoriteCocktail)
    {
        this.favoriteCocktails.add(favoriteCocktail);
    }

    public void removeFavoriteCocktail(CocktailOrder favoriteCocktail)
    {
        this.favoriteCocktails.remove(favoriteCocktail);
    }
}