package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarTests
{
    @Test
    public void CanGetCorrectMenuDetails()
    {
        var bar = new Bar();
        var menuItem = new MenuItem("Bierglas", 10.45);
        var menuCocktail = new MenuCocktail("Martini Porn-star", 45.99);

        menuCocktail.addIngredient("Ananas");
        menuCocktail.addIngredient("Appel");
        menuCocktail.addIngredient("Knoflook");
        menuCocktail.addIngredient("Olijfolie");

        bar.addMenuItem(menuItem);
        bar.addMenuItem(menuCocktail);

        assertEquals(bar.menuDetails(),
            "Bierglas - Prijs: 10.45\n\n" +
            "Martini Porn-star - Prijs: 45.99\n" +
                    "Ingrediënten:\n" +
                    "- Ananas\n" +
                    "- Appel\n" +
                    "- Knoflook\n" +
                    "- Olijfolie\n\n"
        );
    }

    @Test
    public void canGetCorrectPaymentAmountWithOneCocktailOrder() throws MenuItemNotFound
    {
        var order = new Order(new Customer("TestCustomer"));
        var cocktailOrder = new CocktailOrder("MenuCocktail", "MenuItem1");
        cocktailOrder.addAddon("MenuItem2");
        cocktailOrder.addAddon("MenuItem3");

        order.addCocktailOrder(cocktailOrder, 1);

        assertEquals(1344.06, getBar().paymentAmount(order));
    }

    @Test
    public void canGetCorrectPaymentAmountWithThreeCocktailOrders() throws MenuItemNotFound
    {
        var order = new Order(new Customer(""));
        var cocktailOrder1 = new CocktailOrder("MenuCocktail", "MenuItem1");
        cocktailOrder1.addAddon("MenuItem2");
        cocktailOrder1.addAddon("MenuItem3"); //1344.06
        var cocktailOrder2 = new CocktailOrder("MenuCocktail", "MenuItem1"); //23.79

        order.addCocktailOrder(cocktailOrder1, 1);
        order.addCocktailOrder(cocktailOrder2, 2); //47.58

        assertEquals(1391.64, getBar().paymentAmount(order), 0.01);
    }

    @Test
    public void canGetCorrectPaymentAmountWithMoreOrders() throws MenuItemNotFound
    {
        var order1 = new Order(new Customer(""));
        var order2 = new Order(new Customer(""));

        var cocktailOrder1 = new CocktailOrder("MenuCocktail", "MenuItem1");
        cocktailOrder1.addAddon("MenuItem2");
        cocktailOrder1.addAddon("MenuItem3"); //1344.06

        var cocktailOrder2 = new CocktailOrder("MenuCocktail", "MenuItem1"); //23.79

        order1.addCocktailOrder(cocktailOrder1, 1);
        order2.addCocktailOrder(cocktailOrder2, 2); //47.58

        var orders = new HashSet<Order>();
        orders.add(order1);
        orders.add(order2);

        assertEquals(1391.64, getBar().paymentAmount(orders), 0.01);
    }
    
    private Bar getBar()
    {
        var bar = new Bar();
        var menuCocktail = new MenuCocktail("MenuCocktail", 13.34);
        var menuItem1 = new MenuItem("MenuItem1", 10.45);
        var menuItem2 = new MenuItem("MenuItem2", 1274.28);
        var menuItem3 = new MenuCocktail("MenuItem3", 45.99);
        bar.addMenuItem(menuCocktail);
        bar.addMenuItem(menuItem1);
        bar.addMenuItem(menuItem2);
        bar.addMenuItem(menuItem3);
        return bar;
    }
}