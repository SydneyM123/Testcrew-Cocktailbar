package com.Cocktailbar;

import com.Cocktailbar.Exceptions.MenuItemNotFound;

import java.io.IOException;
import java.util.*;

/**
 * The main console application of the cocktail bar
 *
 * @author Sydney Minnaar
 * @author Thomas Luchies
 * @version 1
 */
public class Main
{
    public static void main(String[] args) throws IOException, MenuItemNotFound
    {
        Scanner input = new Scanner(System.in);
        HashSet<Customer> customers = new HashSet<>();
        boolean loggedIn = false;
        Customer currentCustomer = null;
        Customer test = new Customer("test");
        customers.add(test);

        Storage storage = new Storage();
        storage.addGlass("Long Drink Glas");
        storage.addGlass("Long Drink Glas");
        storage.addGlass("Long Drink Glas");
        storage.addGlass("Long Drink Glas");
        storage.addGlass("Bier Glas");
        storage.addGlass("Bier Glas");
        storage.addGlass("Bier Glas");
        storage.addGlass("Bier Glas");
        storage.addGlass("Bier Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Cocktail Glas");
        storage.addGlass("Wijn Glas");
        storage.addGlass("Wijn Glas");
        storage.addGlass("Wijn Glas");
        storage.addGlass("Wijn Glas");
        storage.addIngredient("Strawberry");
        storage.addIngredient("Strawberry");
        storage.addIngredient("Strawberry");
        storage.addIngredient("Strawberry");
        storage.addIngredient("Strawberry");
        storage.addIngredient("Whiskey");
        storage.addIngredient("Whiskey");
        storage.addIngredient("Whiskey");
        storage.addIngredient("Whiskey");
        storage.addIngredient("Whiskey");
        storage.addIngredient("Vodka");
        storage.addIngredient("Vodka");
        storage.addIngredient("Vodka");
        storage.addIngredient("Vodka");
        storage.addIngredient("Vodka");
        storage.addIngredient("Water");
        storage.addIngredient("Water");
        storage.addIngredient("Water");
        storage.addIngredient("Water");
        storage.addIngredient("Lime Juice");
        storage.addIngredient("Lime Juice");
        storage.addIngredient("Lime Juice");
        storage.addIngredient("Lime Juice");
        storage.addIngredient("Lime Juice");
        storage.addIngredient("Tequila");
        storage.addIngredient("Tequila");
        storage.addIngredient("Tequila");
        storage.addIngredient("Tequila");
        storage.addIngredient("Tequila");
        storage.addIngredient("Tequila");
        storage.addIngredient("Cointreau");
        storage.addIngredient("Cointreau");
        storage.addIngredient("Cointreau");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("Ijsklontje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("citroenschijfje");
        storage.addAddon("Rietje");
        storage.addAddon("Rietje");
        storage.addAddon("Rietje");
        storage.addAddon("Rietje");
        storage.addAddon("Rietje");
        storage.addAddon("Rietje");
        storage.addAddon("Paraplutje");
        storage.addAddon("Paraplutje");
        storage.addAddon("Paraplutje");
        storage.addAddon("Paraplutje");
        storage.addAddon("Paraplutje");
        storage.addAddon("Paraplutje");

        Menu menu = new Menu();
        MenuCocktail sexOnTheBeach = new MenuCocktail("Sex on the beach", 4.99);
        sexOnTheBeach.addIngredient("Lime Juice");
        sexOnTheBeach.addIngredient("Vodka");
        MenuCocktail pornstarMartini = new MenuCocktail("Pornstar Martini", 7.99);
        pornstarMartini.addIngredient("Water");
        pornstarMartini.addIngredient("Whiskey");
        pornstarMartini.addIngredient("Strawberry");
        MenuCocktail margarita = new MenuCocktail("Margarita", 6.99);
        margarita.addIngredient("Lime Juice");
        margarita.addIngredient("Tequila");
        margarita.addIngredient("Cointreau");
        MenuCocktail tequilaSunshine = new MenuCocktail("Tequila sunshine", 3.99);
        tequilaSunshine.addIngredient("Strawberry");
        tequilaSunshine.addIngredient("Whiskey");
        tequilaSunshine.addIngredient("Rum");
        MenuGlass LongGlass = new MenuGlass("Long Drink Glas", 0.50);
        MenuGlass beerGlass = new MenuGlass("Bier Glas", 0.50);
        MenuGlass wineGlass = new MenuGlass("Wijn Glas", 0.50);
        MenuGlass cocktailGlass = new MenuGlass("Cocktail Glas", 0.50);
        MenuAddon iceCube = new MenuAddon("Ijsklontje", 0.50);
        MenuAddon limeWedge = new MenuAddon("citroenschijfje", 0.50);
        MenuAddon straw = new MenuAddon("Rietje", 0.50);
        MenuAddon umbrella = new MenuAddon("Paraplutje", 0.50);

        menu.addMenuItem(sexOnTheBeach);
        menu.addMenuItem(pornstarMartini);
        menu.addMenuItem(margarita);
        menu.addMenuItem(tequilaSunshine);
        menu.addMenuItem(LongGlass);
        menu.addMenuItem(beerGlass);
        menu.addMenuItem(cocktailGlass);
        menu.addMenuItem(wineGlass);
        menu.addMenuItem(iceCube);
        menu.addMenuItem(limeWedge);
        menu.addMenuItem(straw);
        menu.addMenuItem(umbrella);

        Bar bar = new Bar(menu, storage);

        loginLoop: while(!loggedIn)
        {
            clearScreen();
            System.out.println("Please select an option:");
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("3: Exit");
            Scanner userInput;
            switch(input.nextInt())
            {
                case 1: // Existing user
                    clearScreen();
                    System.out.print("Please enter your name\n");
                    userInput = new Scanner(System.in);
                    if(customers.isEmpty())
                    {
                        System.out.println("There are no customers registered");
                        pressAnyKeyToContinue();
                        break;
                    }
                    for(Customer customer : customers)
                    {
                        if (customer.getName().contentEquals(userInput.nextLine()))
                        {
                            currentCustomer = customer;
                            loggedIn = true;
                            System.out.println("Welcome " + customer.getName());
                        }
                    }
                    if(!loggedIn) System.out.println("That customer does not exist");
                    pressAnyKeyToContinue();
                    clearScreen();
                    break;
                case 2: // New user
                    clearScreen();
                    System.out.println("Please enter your name ");
                    userInput = new Scanner(System.in);
                    String username = userInput.nextLine();
                    for(Customer customer : customers)
                    {
                        if(customer.getName().contentEquals(username))
                        {
                            System.out.println("A customer with that name already exists");
                        }
                    }
                    customers.add(new Customer(username));
                    System.out.println("Your account has been created!");
                    System.out.println("Welcome " + username);
                    pressAnyKeyToContinue();
                    break;
                case 3: // Exit
                    clearScreen();
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }

        orderLoop: while(loggedIn)
        {
            System.out.println("Please select an option:");
            System.out.println("1: Order ");
            System.out.println("2: Exit");
            boolean orderComplete;
            boolean cocktailComplete = false;
            boolean addonComplete = false;
            boolean glassComplete = false;
            int currentCocktail;
            int currentGlass;
            int currentAddon;
            int addonChosen;
            boolean notEnoughStock = false;
            CocktailOrder mostPopulairCocktail = new CocktailOrder("Cocktail Glas", "Pornstar Martini");
            mostPopulairCocktail.addAddon("Paraplutje");
            MenuCocktail chossenCocktail = null;
            String chossenGlass = null;
            int chossenFavoriteCocktail;
            CocktailOrder cocktailOrder;
            ArrayList<String> glassesList = new ArrayList<>();
            ArrayList<String> addonsList;
            ArrayList<MenuItem> cocktailList;
            HashSet<CocktailOrder> favoriteCocktails;
            Scanner orderInput;
            Order order = new Order(currentCustomer);
            ArrayList<CocktailOrder> favoriteCocktailsList = new ArrayList<>();
            switch(input.nextInt())
            {
                case 1:
                    orderComplete = false;
                    while(!orderComplete)
                    {
                        clearScreen();
                        System.out.println("Please select an option:");
                        System.out.println("1: Create cocktail");
                        System.out.println("2: Order favorite cocktail");
                        orderInput = new Scanner(System.in);
                        switch(orderInput.nextInt())
                        {
                            case 1:
                                clearScreen();
                                System.out.println("What cocktail do you want to order?");
                                cocktailLoop: while(!cocktailComplete)
                                {
                                    currentCocktail = 1;
                                    cocktailList = new ArrayList<>();
                                    for(MenuItem cocktailLoop : menu.getMenuItems())
                                    {
                                        if(cocktailLoop instanceof MenuCocktail)
                                        {
                                            System.out.println(currentCocktail + ": " + cocktailLoop.getName());
                                            cocktailList.add(cocktailLoop);
                                            currentCocktail++;
                                        }
                                    }
                                    orderInput = new Scanner(System.in);
                                    chossenCocktail = (MenuCocktail) cocktailList.get(orderInput.nextInt() - 1);
                                    for(String ingredient : chossenCocktail.getIngredients())
                                    {
                                        if(!storage.getIngredient(ingredient, 1))
                                        {
                                            clearScreen();
                                            System.out.println("We are sorry but the cocktail you wan't isn't in stock please choose another one");
                                            continue cocktailLoop;
                                        }
                                    }
                                    cocktailComplete = true;
                                }
                                clearScreen();
                                while(!glassComplete)
                                {
                                    System.out.println("Which glass do you want?");
                                    currentGlass = 1;
                                    glassLoop: for (MenuItem glass : menu.getMenuItems())
                                    {
                                        if(glass instanceof MenuGlass)
                                        {
                                            System.out.println(currentGlass + " " + glass.getName());
                                            glassesList.add(glass.getName());
                                            currentGlass++;
                                        }
                                    }
                                    orderInput = new Scanner(System.in);
                                    chossenGlass = glassesList.get(orderInput.nextInt() - 1);
                                    if(!storage.getGlass(chossenGlass, 1))
                                    {
                                        clearScreen();
                                        System.out.println("This glass is currently out of stock please select another glass.\n");
                                    }
                                    else
                                    {
                                        glassComplete = true;
                                    }
                                }

                                cocktailOrder = new CocktailOrder(chossenGlass, chossenCocktail.getName());
                                clearScreen();

                                System.out.println("Do you wan't to add a add on?");
                                addonsList = new ArrayList<>();
                                while(!addonComplete)
                                {
                                    currentAddon = 1;
                                    for(MenuItem addon : menu.getMenuItems())
                                    {
                                        if(addon instanceof MenuAddon)
                                        {
                                            System.out.println(currentAddon + ": " + addon.getName());
                                            addonsList.add(addon.getName());
                                            currentAddon++;
                                        }
                                    }
                                    System.out.println(currentAddon + ": none");
                                    orderInput = new Scanner(System.in);
                                    addonChosen = orderInput.nextInt();
                                    if(addonChosen == currentAddon)
                                    {
                                        clearScreen();
                                        break;
                                    }
                                    clearScreen();
                                    if(!storage.getAddon(addonsList.get(addonChosen - 1), 1))
                                    {
                                        System.out.println("This addon is out of stock \n");
                                    }
                                    else
                                    {
                                        cocktailOrder.addAddon(addonsList.get(addonChosen - 1));
                                    }
                                    System.out.println("Do you want to add another add on");
                                    System.out.println("1: Yes");
                                    System.out.println("2: No");
                                    orderInput = new Scanner(System.in);
                                    if(orderInput.nextInt() == 2) addonComplete = true;
                                    clearScreen();
                                }
                                System.out.println("Your cocktail: ");
                                System.out.println("Name: " + cocktailOrder.getCocktail());
                                System.out.println("Glass: " + cocktailOrder.getGlass());
                                System.out.println("Add ons: ");
                                for(String addon : cocktailOrder.getAddons())
                                {
                                    System.out.println("- " + addon);
                                }
                                System.out.println("Do you want to add this cocktail to your order");
                                System.out.println("1: Yes");
                                System.out.println("2: No");
                                orderInput = new Scanner(System.in);
                                if(orderInput.nextInt() == 1) order.addCocktailOrder(cocktailOrder, 1);
                                clearScreen();
                                System.out.println("Do you want to add this cocktail to your favorite cocktails");
                                System.out.println("1: Yes");
                                System.out.println("2: No");
                                orderInput = new Scanner(System.in);
                                if(orderInput.nextInt() == 1)
                                {
                                    currentCustomer.addFavoriteCocktail(cocktailOrder);
                                }
                                break;
                            case 2:
                                clearScreen();
                                favoriteCocktails = currentCustomer.getFavoriteCocktails();
                                if(favoriteCocktails.size() > 0)
                                {
                                    currentCocktail = 1;
                                    for(CocktailOrder favoriteCocktail : favoriteCocktails)
                                    {
                                        System.out.println(currentCocktail + ": " + favoriteCocktail.getCocktail());
                                        favoriteCocktailsList.add(favoriteCocktail);
                                        currentCocktail++;
                                    }
                                }
                                else
                                {
                                    System.out.println("1: " + mostPopulairCocktail.getCocktail());
                                    favoriteCocktailsList.add(mostPopulairCocktail);
                                }
                                orderInput = new Scanner(System.in);
                                chossenFavoriteCocktail = orderInput.nextInt();
                                clearScreen();
                                if(storage.checkStockGlass(favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getGlass()) > 1)
                                {
                                    for(String ingredient : ((MenuCocktail) menu.getByName(favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getCocktail())).getIngredients())
                                    {
                                        if(storage.checkStockIngredient(ingredient) < 1)
                                        {
                                            notEnoughStock = true;
                                        }
                                    }

                                    for(String addOn : favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getAddons())
                                    {
                                        if(storage.checkStockAddon(addOn) < 1)
                                        {
                                            notEnoughStock = true;
                                        }
                                    }
                                }
                                else
                                {
                                    notEnoughStock = true;
                                }
                                if(notEnoughStock)
                                {
                                    System.out.println("There is not enough stock to order this drink.");
                                    notEnoughStock = false;
                                    pressAnyKeyToContinue();
                                    break;
                                }
                                storage.getGlass(favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getGlass(), 1);
                                for(String ingredient : ((MenuCocktail) menu.getByName(favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getCocktail())).getIngredients())
                                {
                                    if(storage.checkStockIngredient(ingredient) < 1)
                                    {
                                        storage.getIngredient(ingredient, 1);
                                    }
                                }

                                for(String addOn : favoriteCocktailsList.get(chossenFavoriteCocktail - 1).getAddons())
                                {
                                    if(storage.checkStockAddon(addOn) < 1)
                                    {
                                        storage.getAddon(addOn, 1);
                                    }
                                }
                                order.addCocktailOrder(favoriteCocktailsList.get(chossenFavoriteCocktail - 1), 1);
                                break;
                        }
                        clearScreen();
                        System.out.println("Do you want to add another cocktail to your order");
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        orderInput = new Scanner(System.in);
                        if(orderInput.nextInt() == 2)
                        {
                            clearScreen();
                            System.out.println("The cocktails you ordered ");
                            for(Map.Entry<CocktailOrder, Integer> cocktailLoop : order.getCocktailOrders().entrySet())
                            {
                                System.out.println("Cocktail: " + cocktailLoop.getKey().getCocktail());
                                System.out.println("Glass: " + cocktailLoop.getKey().getGlass());
                                System.out.println("Add ons: ");
                                for(String addon : cocktailLoop.getKey().getAddons())
                                {
                                    System.out.println("- " + addon);
                                }
                                System.out.println(" Amount: " + cocktailLoop.getValue() + "\n");
                            }
                            System.out.println("\nThe total price of your order is " + bar.paymentAmount(order));
                            pressAnyKeyToContinue();
                            orderComplete = true;
                        }
                        else
                        {
                            glassComplete = false;
                            cocktailComplete = false;
                            addonComplete = false;
                        }
                        clearScreen();
                    }
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    public static void clearScreen()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
