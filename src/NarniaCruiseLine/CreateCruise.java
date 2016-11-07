/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import static NarniaCruiseLine.NarniaCruiseLine.*;
import static NarniaCruiseLine.HelperClass.*;
import java.util.*;
/**
 * This is a class to create new Cruises it has cruiseNames to pick a name for cruise, 
 * captainSlected,doctorSlected, cookSlected, engineerSlected to keep track of sailors that are already on the cruise 
 * it has create() method which basically creates a new Cruise with ship, ports, sailors, passengers
 * @author VinayaSaiD
 */
public class CreateCruise {
    
    static String[] cruiseNames = {"Narnia", "Casper", "Phillp", "Maldives","The Gretcher","Mazze", "Blanchard","The Summers"};
    static String[] shipNames = {"The Great Mac", "Magma", "Maverics", "The Boat","The Alapino","The Tourist"};
    static ArrayList<Integer> captainSlected = new ArrayList<Integer>();
    static ArrayList<Integer> doctorSlected = new ArrayList<Integer>();
    static ArrayList<Integer> cookSlected = new ArrayList<Integer>();
    static ArrayList<Integer> engineerSlected = new ArrayList<Integer>();
    static ArrayList<Integer> shipSlected = new ArrayList<Integer>();
    static ArrayList<Integer> sailorSlected = new ArrayList<Integer>();
    static ArrayList<Integer> superSailorSlected = new ArrayList<Integer>();
    
    public static void create() throws Exception
    {   
        System.out.println("Creating a Cruise.....");
        System.out.println("Cruise Created.Please find details below: \n\n");
        
        
        // if all the ships are used in cruise, create a new ship
        Ship shipForCruise;
        if (shipSlected.size() == shipPresent.size())
        {
            shipForCruise = new Ship(randNumber(), shipNames[randBetween(0,5)], randBetween(19000,52000), randBetween(1850,2005), randBetween(2000,4000));
            appendToFile(shipForCruise.toString(),"ship.txt");
            shipPresent.add(shipForCruise);
        }
        // selecting the ship for the cruise present in the list
        else
        {   int shipIndex = 0;
            boolean inShipSelected = true;
            while (inShipSelected == true)
            {   shipIndex = randBetween(0,shipPresent.size()-1);
                inShipSelected = false;
                for(int km =0; km < shipSlected.size()-1; km++)
                {   if (shipIndex == km)
                    {
                       inShipSelected = true; 
                    }
                }
            }
            shipSlected.add(shipIndex);
            shipForCruise = shipPresent.get(shipIndex);
        }
        Port startPort = portPresent.get(randBetween(0,portPresent.size()-1));
        String newCruiseName = cruiseNames[randBetween(0,7)];
        Date StartCruisedDate = randomDate();
        Cruise cruisenew = new Cruise(randNumber(), newCruiseName, StartCruisedDate,randomEndDate(StartCruisedDate), startPort, shipForCruise ,randBetween(600,1200));
        
        // selecting the ports from the list for the cruise
        int numberOfPorts = randBetween(1,5);
        for(int i =0; i< numberOfPorts; i++)
        {
            cruisenew.portsOfCall.add(portPresent.get(randBetween(0,portPresent.size()-1)));
        }
        
        // adding random number of passengers
        int numberOfPassenger = randBetween(1,4);
        for(int i =0; i< numberOfPassenger; i++)
        { 
            Passenger passengerNew = new Passenger(randSailorID(),personNames.get(randBetween(0,99)), addressNames.get(randBetween(0,99)), countryNames.get(randBetween(0,99)),  randomDateofBirth(), randBetween(600,1200), randBetween(50,320));
            cruisenew.cruisePassengers.add(passengerNew);
            passengerPresent.add(passengerNew);
            appendToFile(passengerNew.toString(),"passengers.txt");
        }
        
        
        // if no captain is present, creating a new captain and adding it to the list of captains and writing back to database
        Sailor captain1;
        if (captainSlected.size() == captainPresent.size())
        {
            captain1 = new Captain(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), false, randBetween(30,430));
            appendToFile(captain1.toString(),"captain.txt");
            captainPresent.add(captain1);
            cruisenew.cruiseSailors.add(captain1);
        }
        //adding a captain to the cruise, from the list
        else
        {
            int captainIndex = 0;
            boolean inSelected = true;
            while (inSelected == true)
            {   captainIndex = randBetween(0,captainPresent.size()-1);
                inSelected = false;
                for(int km =0; km < captainSlected.size()-1; km++)
                {   if (captainIndex == km)
                    {
                       inSelected = true; 
                    }
                }
            }
            captainSlected.add(captainIndex);
            captain1 = captainPresent.get(captainIndex);
            cruisenew.cruiseSailors.add(captain1);
        }
        
        
        // if no cook is present, creating a new cook and adding it to the list of cooks and writing back to database
        Sailor cook1;
        if (cookSlected.size() == cookPresent.size())
        {
            cook1 = new Cook(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), false, randBetween(30,430));
            appendToFile(cook1.toString(),"cook.txt");
            cookPresent.add(cook1);
            cruisenew.cruiseSailors.add(cook1);
        }
        //adding a cook to the cruise, from the list
        else
        {
            int cookIndex = 0;
            boolean inSelectedcook = true;
            while (inSelectedcook == true)
            {   cookIndex = randBetween(0,cookPresent.size()-1);
                inSelectedcook = false;
                for(int km =0; km < cookSlected.size()-1; km++)
                {   if (cookIndex == km)
                    {
                       inSelectedcook = true; 
                    }
                }
            }
            cookSlected.add(cookIndex);
            cook1 = cookPresent.get(cookIndex);
            cruisenew.cruiseSailors.add(cook1);
        }
        
        // if no doctor is present, creating a new doctor and adding it to the list of doctors and writing back to database
        Sailor doctor1;
        if (doctorSlected.size() == doctorPresent.size())
        {
            doctor1 = new Doctor(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), false, randBetween(30,430));
            appendToFile(cook1.toString(),"doctors.txt");
            doctorPresent.add(doctor1);
            cruisenew.cruiseSailors.add(doctor1);
        }
        //adding a doctor to the cruise, from the list
        else
        {
            int doctorIndex = 0;
            boolean inSelecteddoctor = true;
            while (inSelecteddoctor == true)
            {   doctorIndex = randBetween(0,doctorPresent.size()-1);
                inSelecteddoctor = false;
                for(int km =0; km < doctorSlected.size()-1; km++)
                {   if (doctorIndex == km)
                    {
                       inSelecteddoctor = true; 
                    }
                }
            }
            doctorSlected.add(doctorIndex);
            doctor1 = doctorPresent.get(doctorIndex);
            cruisenew.cruiseSailors.add(doctor1);
        }
        
        // if no engineer is present, creating a new engineer and adding it to the list of engineers and writing back to database
        Sailor engineer1;
        if (engineerSlected.size() == engineerPresent.size())
        {
            engineer1 = new Engineer(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), false, randBetween(30,430));
            appendToFile(cook1.toString(),"engineers.txt");
            engineerPresent.add(engineer1);
            cruisenew.cruiseSailors.add(engineer1);
        }
        //adding a engineer to the cruise, from the list
        else
        {
            int engineerIndex = 0;
            boolean inSelectedengineer = true;
            while (inSelectedengineer == true)
            {   engineerIndex = randBetween(0,engineerPresent.size()-1);
                inSelectedengineer = false;
                for(int km =0; km < engineerSlected.size()-1; km++)
                {   if (engineerIndex == km)
                    {
                       inSelectedengineer = true; 
                    }
                }
            }
            engineerSlected.add(engineerIndex);
            engineer1 = engineerPresent.get(engineerIndex);
            cruisenew.cruiseSailors.add(engineer1);
        }
        
        
        // if no supersailor is present, creating a new supersailor and adding it to the list of supersailors and writing back to database
        SuperSailor superSailor1;
        if (superSailorSlected.size() == superSailorPresent.size())
        {
            superSailor1 = new SuperSailor(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), randBetween(30,430));
            appendToFile(superSailor1.toString(),"sailor.txt");
            superSailorPresent.add(superSailor1);
            cruisenew.cruiseSailors.add(superSailor1);
        }
        //adding a supersailor to the cruise, from the list
        else
        {
            int supersailorIndex = 0;
            boolean inSelectedSuperSailor = true;
            while (inSelectedSuperSailor == true)
            {   supersailorIndex = randBetween(0,superSailorPresent.size()-1);
                inSelectedSuperSailor = false;
                for(int km =0; km < superSailorSlected.size()-1; km++)
                {   if (supersailorIndex == km)
                    {
                       inSelectedSuperSailor = true; 
                    }
                }
            }
            superSailorSlected.add(supersailorIndex);
            superSailor1 = superSailorPresent.get(supersailorIndex);
            cruisenew.cruiseSailors.add(superSailor1);
        }
        
        //adding a sailors to the cruise, from the list
        int numberOfRandomSailors = randBetween(1,10);
        for(int k =0; k< numberOfRandomSailors; k++)
        {
            Sailor Sailor1;
            // if no sailor is present, creating a new sailor and adding it to the list of sailors and writing back to database
            if (sailorSlected.size() == sailorPresent.size())
            {
                Sailor1 = new Sailor(randSailorID(), personNames.get(randBetween(0,99)), randomDateofBirth() , countryNames.get(randBetween(0,99)), false, randBetween(10,430), "Sailor");
                appendToFile(Sailor1.toString(),"sailor.txt");
                sailorPresent.add(Sailor1);
                cruisenew.cruiseSailors.add(Sailor1);
            }
            //adding a sailor to the cruise, from the list
            else
            {
                int sailorIndex = 0;
                boolean inSelectedSailor = true;
                while (inSelectedSailor == true)
                {   sailorIndex = randBetween(0,sailorPresent.size()-1);
                    inSelectedSailor = false;
                    for(int km =0; km < sailorSlected.size()-1; km++)
                    {   if (sailorIndex == km)
                        {
                           inSelectedSailor = true; 
                        }
                    }
                }
                sailorSlected.add(sailorIndex);
                Sailor1 = sailorPresent.get(sailorIndex);
                cruisenew.cruiseSailors.add(Sailor1);
            }
        }
        cruisePresent.add(cruisenew);
        
        cruisenew.printCruiseDetails(cruisenew);
        System.out.println();
    }
}
