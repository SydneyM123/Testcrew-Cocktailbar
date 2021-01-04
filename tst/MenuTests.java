import com.Cocktailbar.Menu;
import com.Cocktailbar.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTests
{
    @Test
    public void canGetByName() throws Menu.MenuItemNotFound
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
        assertThrows(Menu.MenuItemNotFound.class, () -> menu.getByName(""));
    }
}