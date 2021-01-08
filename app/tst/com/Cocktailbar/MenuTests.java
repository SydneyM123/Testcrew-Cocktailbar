package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTests
{
    @Test
    public void canGetByName() throws MenuItemNotFound
    {
        var menuItem = new MenuItem("MenuItem", 0.00);
        var menu = new Menu();
        menu.addMenuItem(menuItem);
        assertEquals(menuItem, menu.getByName("MenuItem"));
    }

    @Test
    public void canThrowMenuItemNotFound()
    {
        var menu = new Menu();
        assertThrows(MenuItemNotFound.class, () -> menu.getByName(""));
    }
}