/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This is used to print the console based interactive menu for user to interact with the "Narnia Cruise Lines".
 * @author VinayaSaiD
 */
public class MenuBody {
    public static void printMenu() throws Exception
    {
        // To get the current date
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println(dateFormat.format(date) + "\nWelcome to Narnia Cruise Lines \n ");
        
        // to print the interactive menu for user
        boolean wronginput = true;
        Scanner input = new Scanner(System.in); 
        int optionChoosen = 0;
        while(wronginput == true)
        {
            System.out.println("Please select your option from below:");
            System.out.println("1. Create a cruise ");
            System.out.println("2. Add passengers to a cruise");
            System.out.println("3. Provide reports");
            System.out.println("4. Update the database");
            System.out.println("5. Exit the System");
            optionChoosen = input.nextInt();
            if (optionChoosen == 1 || optionChoosen  == 2 || optionChoosen == 3 || optionChoosen == 4 || optionChoosen == 5)
            {   wronginput = false;
            }
            else
            {   System.out.println("\nWrong input entered \n");
            }
        }
        // based on the option selected using the switch case to call the respective classes
        switch (optionChoosen)
        {
            case 1 : CreateCruise.create() ; System.out.println("\n\n\n"); printMenu();
            case 2 : AddPassengers.createAddPassengers() ; System.out.println("\n\n\n"); printMenu();
            case 3 : CruiseReport.create() ; System.out.println("\n\n\n"); printMenu();
            case 4 : UpdateDatabase.savingFiles();System.out.println("\nUpdate of database done. Files stored to database.\n\n");printMenu();
            case 5 : System.exit(0);break;
            default: System.exit(0);
        }
    }
    
}
