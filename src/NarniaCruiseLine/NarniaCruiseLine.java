/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;
import java.lang.*;
import java.text.*;
import static NarniaCruiseLine.HelperClass.*;
import static NarniaCruiseLine.Port.*;
import static NarniaCruiseLine.MenuBody.*;

/**
 * This class is mainly used to initiate the "Narnia Cruise Lines" System
 * Read the passengers, sailors details from the text files and printMenu() prints the options for the user to choose what to do
 * initializeCruises() initializes 3 cruises as sample cruise
 * shipPresent, sailorPresent, captainPresent, engineerPresent, doctorPresent, cookPresent, passengerPresent, cruisePresent are the
 * variables to maintain the assets present with the company which gets values from text files.
 * @author VinayaSaiD
 */
public class NarniaCruiseLine {

    /**
     * @param args the command line arguments
     */
    // These variables maintain all the assets present with the cruise company (the ones that are presnt in the database)
    static ArrayList<Ship> shipPresent = new ArrayList<Ship>() ;
    static ArrayList<Port> portPresent = new ArrayList<Port>();
    static ArrayList<Sailor> sailorPresent = new ArrayList<Sailor>();
    static ArrayList<SuperSailor> superSailorPresent = new ArrayList<SuperSailor>();
    static ArrayList<Sailor> captainPresent = new ArrayList<Sailor>(); 
    static ArrayList<Sailor> engineerPresent = new ArrayList<Sailor>();
    static ArrayList<Sailor> doctorPresent = new ArrayList<Sailor>();
    static ArrayList<Sailor> cookPresent = new ArrayList<Sailor>();
    static ArrayList<Passenger> passengerPresent = new ArrayList<Passenger>();
    static ArrayList<Cruise> cruisePresent = new ArrayList<Cruise>();
    
    public static void main(String[] args) throws Exception
    {   
        // read the names of persons, coutries and cities froma text file
        HelperClass.readNamesFile("basic.txt");
        // reading the ports that the company uses from the text file
        ArrayList<String> portslines = readFile("Ports.txt");
        String eachline = "";
        String[] tempArray;
        for (int i=0;i< (portslines.size());i++)
        {
            eachline = portslines.get(i);
            tempArray = eachline.split(",");
            int population = Integer.parseInt(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[3]);
            Port port = new Port(tempArray[0],tempArray[1],population,bol);
            portPresent.add(port);
        }
        
        // reading all the captains that the company has from the text file
        ArrayList<String> captainlines = readFile("captain.txt");
        for (int i=0;i< (captainlines.size());i++)
        {
            eachline = captainlines.get(i);
            tempArray = eachline.split(",");
            long sailorid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[4]);
            double money = Double.parseDouble(tempArray[5]);
            Captain captain = new Captain(sailorid, tempArray[1], dateBirth , tempArray[3], bol, money,tempArray[6]);
            captainPresent.add(captain);
        }
        
        // reading all the engineers that the company has from the text file
        ArrayList<String> enginelines = readFile("engineers.txt");
        for (int i=0;i< (enginelines.size());i++)
        {
            eachline = enginelines.get(i);
            tempArray = eachline.split(",");
            long sailorid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[4]);
            double money = Double.parseDouble(tempArray[5]);
            Engineer engineer = new Engineer(sailorid, tempArray[1], dateBirth , tempArray[3], bol, money,tempArray[6]);
            engineerPresent.add(engineer);
        }
        
        // reading all the doctors that the company has from the text file
        ArrayList<String> doctorlines = readFile("doctors.txt");
        for (int i=0;i< (doctorlines.size());i++)
        {
            eachline = doctorlines.get(i);
            tempArray = eachline.split(",");
            long sailorid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[4]);
            double money = Double.parseDouble(tempArray[5]);
            Doctor doctor = new Doctor(sailorid, tempArray[1], dateBirth , tempArray[3], bol, money,tempArray[6]);
            doctorPresent.add(doctor);
        }
        
        // reading all the cook that the company has from the text file
        ArrayList<String> cooklines = readFile("cook.txt");
        for (int i=0;i< (cooklines.size());i++)
        {
            eachline = cooklines.get(i);
            tempArray = eachline.split(",");
            long sailorid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[4]);
            double money = Double.parseDouble(tempArray[5]);
            Cook cook = new Cook(sailorid, tempArray[1], dateBirth , tempArray[3], bol, money,tempArray[6]);
            cookPresent.add(cook);
        }
        
        // reading all the sailors including supervisors that the company has from the text file
        ArrayList<String> sailorlines = readFile("sailor.txt");
        for (int i=0;i< (sailorlines.size());i++)
        {
            eachline = sailorlines.get(i);
            tempArray = eachline.split(",");
            
            long sailorid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[2]);
            boolean bol = Boolean.parseBoolean(tempArray[4]);
            double money = Double.parseDouble(tempArray[5]);
            Sailor sailor;
            SuperSailor spSailor;
            if (bol == true)
            {
                spSailor = new SuperSailor(sailorid, tempArray[1], dateBirth , tempArray[3], money,tempArray[6]);
                superSailorPresent.add(spSailor);
            }
            else
            {
                sailor = new Sailor(sailorid, tempArray[1], dateBirth , tempArray[3], false, money,tempArray[6]);
                sailorPresent.add(sailor);
                
            }
        }
        
        // reading all the passengers that ever booked a cruise with the company, from the text file
        ArrayList<String> passengerlines = readFile("passengers.txt");
        for (int i=0;i< (passengerlines.size());i++)
        {
            eachline = passengerlines.get(i);
            tempArray = eachline.split(",");
            //System.out.println(i);
            //System.out.println(Arrays.toString(tempArray));
            long passengerid = Long.parseLong(tempArray[0]);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            Date dateBirth = df.parse(tempArray[3]);
            double moneySpent = Double.parseDouble(tempArray[6]);
            double money = Double.parseDouble(tempArray[5]);
            Passenger passenger = new Passenger(passengerid, tempArray[1],tempArray[2], tempArray[4],dateBirth , money, moneySpent);
            passengerPresent.add(passenger);
        }
        
        // reading all the ships that the company has from the text file
        ArrayList<String> shiplines = readFile("ship.txt");
        for (int i=0;i< (shiplines.size());i++)
        {
            eachline = shiplines.get(i);
            tempArray = eachline.split(",");
            //System.out.println(i);
            //System.out.println(Arrays.toString(tempArray));
            long passengerid = Long.parseLong(tempArray[0]);
            double weight = Double.parseDouble(tempArray[2]);
            int year = Integer.parseInt(tempArray[3]);
            int passengers = Integer.parseInt(tempArray[4]);
            Ship shipNew = new Ship(passengerid, tempArray[1],weight, year,passengers);
            shipPresent.add(shipNew);
        }
        
        // initialising 3 cruises
        initializeCruises();
        // print the interface to work with user
        printMenu();
    }
    
    public static void initializeCruises() throws Exception
    {
        Calendar cal = Calendar.getInstance();
        // creating a cruise to show some features I have in my program
        cal.setTimeInMillis(0);
        cal.set(2016, 9, 5, 23, 30);
        Date cruise1StratDate = cal.getTime(); // get back a Date object
        Cruise cruise1 = new Cruise(randNumber(), "The Marine" , cruise1StratDate, new Date(),portPresent.get(randBetween(0,portPresent.size()-1)) , shipPresent.get(0) ,800);
        cruise1.addPortsOfCall(cruise1,portPresent.get(randBetween(0,portPresent.size()-1)));
        cruise1.addPortsOfCall(cruise1,portPresent.get(randBetween(0,portPresent.size()-1)));
        cruise1.addCruisePassengers(passengerPresent.get(randBetween(0,passengerPresent.size()-1)));
        cruise1.addCruisePassengers(passengerPresent.get(randBetween(0,passengerPresent.size()-1)));
        cruise1.addCruiseSailors(captainPresent.get(randBetween(0,captainPresent.size()-1)));
        cruise1.addCruiseSailors(doctorPresent.get(randBetween(0,doctorPresent.size()-1)));
        cruise1.addCruiseSailors(engineerPresent.get(randBetween(0,engineerPresent.size()-1)));
        cruise1.addCruiseSailors(cookPresent.get(randBetween(0,cookPresent.size()-1)));
        cruise1.addCruiseSailors(sailorPresent.get(randBetween(0,3)));
        cruise1.addCruiseSailors(sailorPresent.get(randBetween(3,6)));
        
        cruisePresent.add(cruise1);
        // creating 2 more cruise just as samples
        CreateCruise.create();
        CreateCruise.create();
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }
}