/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;
import static NarniaCruiseLine.NarniaCruiseLine.*;
import static NarniaCruiseLine.HelperClass.*;
import static NarniaCruiseLine.CreateCruise.*;

/**
 * This class is used when the user chooses to add Passengers to the existing cruise
 * createAddPassengers() is the method which asks for selecting the cruise, number of passengers to be added
 * and the way to add Passengers (automatic or manual),
 * automaticPassenger() is used to  create the passengers randomly
 * manualPassenger() is used to add passengers by entering the details one by one
 * @author VinayaSaiD
 */
public class AddPassengers
{
    public static void createAddPassengers() throws Exception
    {    
        boolean wrongInput = true;
        Scanner input = new Scanner(System.in); 
        int addPassengerOption = 0;
        // take the input if he wants to add manually or automatically
        while(wrongInput == true)
        {
            System.out.println("Please select your option from below:");
            System.out.println("1. Add a passenger automatically ");
            System.out.println("2. Add passenger manually");
            addPassengerOption = input.nextInt();
            if (addPassengerOption == 1 || addPassengerOption == 2)
            {   wrongInput = false;
            }
            else
            {   System.out.println("\nWrong input entered. \n");
            }
        }
        // print all the cruise that are present
        printCruisePresent();
        
        //ask the user to select from the cruise present
        Scanner input1 = new Scanner(System.in); 
        int cruisePosition = 0;
        boolean wrongInput1 = true;
        while(wrongInput1 == true)
        {   
            System.out.println("\nPlease choose the Cruise to which you want to add the passenger:"); 
            cruisePosition = input1.nextInt();
            int cruiseListLength = NarniaCruiseLine.cruisePresent.size();
            for(int a=1; a <= cruiseListLength;a++)
            {
                Date cruiseStartDate = cruisePresent.get((cruisePosition-1)).getSailinDate();
                if (cruisePosition == a && cruiseStartDate.after(new Date()))
                {   wrongInput1 = false;
                }
                
            }
            Date cruiseStartDate = cruisePresent.get((cruisePosition-1)).getSailinDate();
            if (wrongInput1 == true)
            {   if (cruiseStartDate.before(new Date()))
                {
                System.out.println("Cannot add passengers to cruise after the start date: " + dateToString(cruiseStartDate));
                }
                 System.out.println("\nWrong input entered. \n");
            }
        }
        int cruiseIdex = cruisePosition -1;
        
        // take the number of passengers user want to add
        Scanner input2 = new Scanner(System.in); 
        int noOfPassengers = 0;
        boolean wrongInput2 = true;
        while(wrongInput2 == true)
        {   
            System.out.println("\nPlease enter the number of passengers you want to add:"); 
            int cruiseShipCapacity = cruisePresent.get(cruiseIdex).getCruiseShip().getPassengerCapacity();
            int passengersOnShip = cruisePresent.get(cruiseIdex).cruisePassengers.size() ;
            int leftShipCapacity = cruiseShipCapacity - passengersOnShip;
            
            noOfPassengers = input2.nextInt();
            if (noOfPassengers <= leftShipCapacity)
                {   
                    wrongInput2 = false;
                }
            else
            {
                System.out.println("\nWrong input entered. The Maximum capacity of the ship is " + cruiseShipCapacity);
                System.out.println("Maximum " + leftShipCapacity + " passengers can only be added.");
            }
        }
        // go to different methods based on the user choice
        switch (addPassengerOption)
        {
            case 1 : automaticPassenger(cruiseIdex,noOfPassengers) ; break;
            case 2 : manualPassenger(cruiseIdex,noOfPassengers) ; break;
        }
    }
    
    public static void automaticPassenger(int cruiseIdex,int noOfPassengers) throws Exception
    {   
        Cruise cruiseSelected = cruisePresent.get(cruiseIdex);
        for(int p=1; p<= noOfPassengers; p++)
        {
        Passenger presentPassenger = new Passenger(randSailorID(),personNames.get(randBetween(0,99)), addressNames.get(randBetween(0,99)), countryNames.get(randBetween(0,99)),  randomDateofBirth(), randBetween(700,1100),randBetween(0,650));
        cruiseSelected.cruisePassengers.add(presentPassenger);
        passengerPresent.add(presentPassenger);
        appendToFile(presentPassenger.toString(),"passengers.txt");
        }
        System.out.println("\nPlease find the Cruise details after adding " + noOfPassengers + " passengers: \n");
        cruiseSelected.printCruiseDetails(cruiseSelected);
    }
    
    public static void manualPassenger(int cruiseIdex,int noOfPassengers) throws Exception
    {
        Cruise cruiseSelected = cruisePresent.get(cruiseIdex);
        String namePassenger;
        String addresshome;
        String nationalityPassenger;
        String dateOfBirthPassenger;
        double paidMoney;
        Scanner input3 = new Scanner(System.in); 
        Scanner input4 = new Scanner(System.in); 
        Scanner input5 = new Scanner(System.in); 
        Scanner input6 = new Scanner(System.in); 
        // Taking various inputs to create a passenger
        System.out.println("\nYou have selected to add passenger manually.\nPlease enter the passenger details. ");
        for(int p=1; p<= noOfPassengers; p++)
        {
            System.out.println("\nPlease enter Passenger's name:"); 
            namePassenger = input3.nextLine();
            System.out.println("\nPlease enter Passenger's Home Address(without any special characters):"); 
            addresshome = input4.nextLine();
            System.out.println("\nPlease enter Passenger's nationaliy:"); 
            nationalityPassenger = input5.nextLine();
            boolean wrongDate = true;
            Date dateOfBirth = new Date();
            while (wrongDate == true)
            {
                System.out.println("\nPlease enter Passenger's Date of Birth (MM-DD-YYYY):"); 
                dateOfBirthPassenger = input6.nextLine();
                String[] dateParts = dateOfBirthPassenger.split("-");
                int year = Integer.parseInt(dateParts[2]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[0]);
                GregorianCalendar gc = new GregorianCalendar(year, month, 1);
                Calendar cal = Calendar.getInstance();
                int maxDayOfMonth = gc.getActualMaximum(gc.DAY_OF_MONTH);
                if (day <= maxDayOfMonth && year < (cal.get(cal.YEAR)) && (month > 0 && month < 12))
                {   gc.set(year, month, day);
                    dateOfBirth = gc.getTime();
                    wrongDate = false;
                }
                else
                {   System.out.println("\n Wrong Date entered.");
                }
            }
            Passenger presentPassenger = new Passenger(randSailorID(),namePassenger, addresshome, nationalityPassenger, dateOfBirth, cruiseSelected.getCruiseTicketCost(), randBetween(50,430));
            cruiseSelected.addCruisePassengers(presentPassenger);
            passengerPresent.add(presentPassenger);
            appendToFile(presentPassenger.toString(),"passengers.txt");
        }
        System.out.println("\n Please find the Cruise details after adding " +  noOfPassengers + " passengers.\n");
        cruiseSelected.printCruiseDetails(cruiseSelected);
    }
}
