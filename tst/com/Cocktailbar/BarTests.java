package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;
import com.Cocktailbar.Exceptions.OutOfStock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(1344.06, getBar(new Storage(), new ArrayList<>()).paymentAmount(order));
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

        assertEquals(1391.64, getBar(new Storage(), new ArrayList<>()).paymentAmount(order), 0.01);
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

        assertEquals(1391.64, getBar(new Storage(), new ArrayList<>()).paymentAmount(orders), 0.01);
    }

    @Test
    public void canThrowMenuItemNotFound_whenCocktailDoesNotExist()
    {
        var bar = getBar(new Storage(), new ArrayList<>());
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);

        order.addCocktailOrder(new CocktailOrder(), 1);
        orders.add(order);

        assertThrows(MenuItemNotFound.class, () -> bar.order(orders));
    }

    @Test
    public void canThrowOutOfStock_whenGlassDoesNotExistInStorage()
    {
        var storage = new Storage();
        var bar = getBar(storage, new ArrayList<>());
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);

        order.addCocktailOrder(new CocktailOrder("", "MenuCocktail"), 1);
        orders.add(order);

        assertThrows(OutOfStock.class, () -> bar.order(orders));
    }

    @Test
    public void canThrowOutOfStock_whenIngredientDoesNotExistInStorage()
    {
        var storage = new Storage();
        var ingredients = new ArrayList<String>();
        var bar = getBar(storage, ingredients);
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);
        var cocktailOrder = new CocktailOrder();

        ingredients.add("Banaan");
        storage.addGlass("");
        cocktailOrder.setCocktail("MenuCocktail");
        order.addCocktailOrder(cocktailOrder, 1);
        orders.add(order);

        assertThrows(OutOfStock.class, () -> bar.order(orders));
    }

    @Test
    public void canThrowOutOfStock_whenAddonDoesNotExistInStorage()
    {
        var storage = new Storage();
        var ingredients = new ArrayList<String>();
        var bar = getBar(storage, ingredients);
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);
        var cocktailOrder = new CocktailOrder();

        storage.addGlass("");
        storage.addIngredient("Banaan");
        cocktailOrder.addAddon("Ijsklontjes");
        ingredients.add("Banaan");
        cocktailOrder.setCocktail("MenuCocktail");
        order.addCocktailOrder(cocktailOrder, 1);
        orders.add(order);

        assertThrows(OutOfStock.class, () -> bar.order(orders));
    }

    @Test
    public void canOrderOneCocktail() throws OutOfStock, MenuItemNotFound
    {
        var storage = new Storage();
        var ingredients = new ArrayList<String>();
        var bar = getBar(storage, ingredients);
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);
        var cocktailOrder = new CocktailOrder("Bierglas", "MenuCocktail");

        storage.addGlass("Bierglas");
        storage.addIngredient("Banaan");
        storage.addAddon("Ijsklontjes");
        cocktailOrder.addAddon("Ijsklontjes");
        ingredients.add("Banaan");
        order.addCocktailOrder(cocktailOrder, 1);
        orders.add(order);

        var result = bar.order(orders);

        assertEquals(1, result.size());

        for (var entry : result.entrySet())
        {
            var cocktail = entry.getKey();
            assertEquals(1, entry.getValue());
            assertEquals("Bierglas", cocktail.getGlass());
            assertEquals("MenuCocktail", cocktail.getName());
            assertTrue(cocktail.getAddons().contains("Ijsklontjes"));
            assertTrue(cocktail.getIngredients().contains("Banaan"));
        }
    }

    @Test
    public void canOrderThreeOfTheSameCocktail() throws OutOfStock, MenuItemNotFound
    {
        var storage = new Storage();
        var ingredients = new ArrayList<String>();
        var bar = getBar(storage, ingredients);
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);
        var cocktailOrder = new CocktailOrder("Bierglas", "MenuCocktail");

        storage.addGlass("Bierglas");
        storage.addIngredient("Banaan");
        storage.addAddon("Ijsklontjes");
        cocktailOrder.addAddon("Ijsklontjes");
        ingredients.add("Banaan");
        order.addCocktailOrder(cocktailOrder, 3);
        orders.add(order);

        var result = bar.order(orders);

        assertEquals(1, result.size());

        for (var entry : result.entrySet())
        {
            var cocktail = entry.getKey();
            assertEquals(3, entry.getValue());
            assertEquals("Bierglas", cocktail.getGlass());
            assertEquals("MenuCocktail", cocktail.getName());
            assertTrue(cocktail.getAddons().contains("Ijsklontjes"));
            assertTrue(cocktail.getIngredients().contains("Banaan"));
        }
    }

    @Test
    public void canOrderTwoDifferentCocktails() throws OutOfStock, MenuItemNotFound
    {
        var storage = new Storage();
        var ingredients = new ArrayList<String>();
        var bar = getBar(storage, ingredients);
        var customer = new Customer("Jaap");
        var orders = new HashSet<Order>();
        var order = new Order(customer);
        var cocktailOrder1 = new CocktailOrder("Bierglas", "MenuCocktail");
        var cocktailOrder2 = new CocktailOrder("Bierglas", "MenuItem3");

        storage.addGlass("Bierglas");
        storage.addGlass("Bierglas");
        storage.addIngredient("Banaan");
        storage.addAddon("Ijsklontjes");
        storage.addAddon("Ijsklontjes");
        cocktailOrder1.addAddon("Ijsklontjes");
        cocktailOrder2.addAddon("Ijsklontjes");
        ingredients.add("Banaan");
        order.addCocktailOrder(cocktailOrder1, 2);
        order.addCocktailOrder(cocktailOrder2, 1);
        orders.add(order);

        var result = bar.order(orders);

        assertEquals(2, result.size());

        var cocktailsAmount = result.values();
        assertTrue(cocktailsAmount.contains(2));
        assertTrue(cocktailsAmount.contains(1));
    }
    
    private Bar getBar(Storage storage, ArrayList<String> ingredients)
    {
        var bar = new Bar(storage);
        var menuCocktail = new MenuCocktail("MenuCocktail", 13.34, ingredients);
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