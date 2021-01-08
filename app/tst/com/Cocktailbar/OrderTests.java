package com.Cocktailbar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests
{
    @Test
    public void canSetCorrectOrderId()
    {
        var order = new Order(new Customer("TestCustomer"));
        assertEquals(Order.ORDER_ID - 1, order.getOrderId());
    }

    @Test
    public void canAddUpCocktailOrderAmount()
    {
        var order = new Order(new Customer("TestCustomer"));
        var cocktailOrder = new CocktailOrder();
        order.addCocktailOrder(cocktailOrder, 1);
        order.addCocktailOrder(cocktailOrder, 1);
        assertEquals(2, order.getCocktailOrders().get(cocktailOrder));
    }
}