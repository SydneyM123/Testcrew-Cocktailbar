package com.Cocktailbar;

import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        HashSet<Customer> customers = new HashSet<>();
        boolean loggedIn = false;
        Customer currentCustomer = null;
        Customer test = new Customer("test");
        test.addFavoriteCocktail(new CocktailOrder("longGlass", "Cocktail1"));
        test.addFavoriteCocktail(new CocktailOrder("longGlass", "Cocktail2"));
        test.addFavoriteCocktail(new CocktailOrder("longGlass", "Cocktail3"));
        customers.add(test);

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
                    System.out.print("please enter your name\n");
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
                    System.out.println("please enter your name ");
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
                    System.out.println("Goodbye!");
                    break loginLoop;
            }
        }

        orderLoop: while(loggedIn)
        {
            System.out.println("Please select an option:");
            System.out.println("1: Order ");
            System.out.println("2: Exit");
            Scanner userInput;
            boolean orderComplete;
            HashSet<CocktailOrder> favoriteCocktails = new HashSet<>();
            Scanner orderInput;
            int currentCocktail;
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
                                break;
                            case 2:
                                clearScreen();
                                favoriteCocktails = currentCustomer.getFavoriteCocktails();
                                currentCocktail = 1;
                                for(CocktailOrder favoriteCocktail : favoriteCocktails)
                                {
                                    System.out.println(currentCocktail + ": " + favoriteCocktail.getCocktail());
                                    favoriteCocktailsList.add(favoriteCocktail);
                                    currentCocktail++;
                                }
                                orderInput = new Scanner(System.in);
                                order.addCocktailOrder(favoriteCocktailsList.get(orderInput.nextInt() -1), 1);
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
                            for(Map.Entry<CocktailOrder, Integer> cocktail : order.getCocktailOrders().entrySet())
                            {
                                System.out.println(cocktail.getKey().getCocktail() + " Amount: " + cocktail.getValue());
                            }
                            System.out.println("\nThe total price of your order is ");
                            pressAnyKeyToContinue();
                            orderComplete = true;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break orderLoop;
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
