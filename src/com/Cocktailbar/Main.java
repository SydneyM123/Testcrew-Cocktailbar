package com.Cocktailbar;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Customer> customers = new ArrayList<>();

        while(true)
        {
            Scanner input = new Scanner(System.in);
            boolean loggedIn = false;
            System.out.println("Please select an option:");
            System.out.println("1: Login");
            System.out.println("2: Register");
            Scanner userInput;
            while(!loggedIn)
            {
                switch(input.nextInt())
                {
                    case 1: // Existing user
                        System.out.print("please enter your name");
                        userInput = new Scanner(System.in);
                        for(Customer customer : customers)
                        {
                            if (customer.getName().contentEquals(userInput.nextLine()))
                            {
                                loggedIn = true;
                                break;
                            }
                        }
                        System.out.println("That customer does not exist");
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
                        break;
                }
            }
        }
    }
}