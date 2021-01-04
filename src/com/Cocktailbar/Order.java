package com.Cocktailbar;

import java.util.HashMap;

public class Order
{
    public static int ORDER_ID = 0;

    private final int orderId;
    private final HashMap<CocktailOrder, Integer> cocktailOrders;
    private final Customer customer;

    public Order(Customer customer)
    {
        orderId = ORDER_ID++;
        cocktailOrders = new HashMap<>();
        this.customer = customer;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public HashMap<CocktailOrder, Integer> getCocktailOrders()
    {
        return cocktailOrders;
    }

    public void addCocktailOrder(CocktailOrder cocktailOrder, Integer amount)
    {
        this.cocktailOrders.put(cocktailOrder, amount);
    }

    public void removeCocktailOrder(CocktailOrder cocktailOrder)
    {
        this.cocktailOrders.remove(cocktailOrder);
    }

    public Customer getCustomer()
    {
        return customer;
    }
}