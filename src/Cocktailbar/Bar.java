package Cocktailbar;

import java.util.ArrayList;

/**
 * Represents a cocktail-bar.
 *
 * @author 4753046
 * @version 0.1
 */
public class Bar
{
    private Menu menu;

    public Bar(Menu menu)
    {
        this.menu = menu;
    }

    public Bar()
    {
        this.menu = new Menu(new ArrayList<>());
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void addMenuItem(MenuItem menuItem)
    {
        this.menu.addMenuItem(menuItem);
    }

    public String menuDetails()
    {
        StringBuilder sb = new StringBuilder();
        for (var menuItem : menu.getMenuItems())
            appendMenuItem(sb, menuItem).append("\n");
        return sb.toString();
    }

    private StringBuilder appendMenuItem(StringBuilder sb, MenuItem menuItem)
    {
        sb.append(menuItem.getName()).append(" - Prijs: ").append(menuItem.getPrice()).append("\n");
        if (menuItem instanceof MenuCocktail)
            appendMenuCocktail(sb, (MenuCocktail) menuItem);
        return sb;
    }

    private StringBuilder appendMenuCocktail(StringBuilder sb, MenuCocktail menuItem)
    {
        var menuCocktail = menuItem;
        sb.append("Ingrediënten:").append("\n");
        for (var ingredient : menuCocktail.getIngredients())
            sb.append("- ").append(ingredient).append("\n");
        return sb;
    }
}