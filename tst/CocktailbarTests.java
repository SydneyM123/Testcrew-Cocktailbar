import Cocktailbar.Bar;
import Cocktailbar.MenuCocktail;
import Cocktailbar.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CocktailbarTests
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
}