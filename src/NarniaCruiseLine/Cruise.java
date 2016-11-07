/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;

/**
 * This is a class for Cruises it has cruiseSerialNumber,cruiseName, sailinDate,returnDate, departurePort, 
 * portsOfCall, cruiseShip, cruiseTicketCost, cruisePassengers and cruiseSailors
 * to represent various attributes of a Cruise,
 * it has get and set methods for all the private variables, printCruiseDetails() to print the details of a Cruise object,
 * toString() to convert Cruise Object into a string
 * @author VinayaSaiD
 */
public class Cruise {
    private long cruiseSerialNumber;
    private String cruiseName;
    private Date sailinDate;
    private Date returnDate;
    private Port departurePort;
    ArrayList<Port> portsOfCall = new ArrayList<Port>();
    private Ship cruiseShip;
    public double cruiseTicketCost;
    ArrayList<Passenger> cruisePassengers = new ArrayList<Passenger>();
    ArrayList<Sailor> cruiseSailors = new ArrayList<Sailor>();
    
    // default constructor
    public Cruise()
    {
    }
    
    //specific constructor with parameters
    public Cruise(long number, String name, Date indate, Date date)
    {
        setCruiseSerialNumber(number);
        setCruiseName(name);
        setSailinDate(indate);
        setReturnDate(date);
    }
    
    public Cruise(long number, String name, Date indate, Date date, Port port, Ship ship, double cost)
    {
        this(number,name,indate,date);
        setDeparturePort (port);
        cruiseShip = ship;
        cruiseTicketCost = cost;
    }
    
    public long getCruiseSerialNumber()
    {   return cruiseSerialNumber;
    }
    public void setCruiseSerialNumber(long number)
    {   cruiseSerialNumber = number;
    }
    
    public Date getSailinDate()
    {   return sailinDate;
    }
    public void setSailinDate(Date indate)
    {   sailinDate = indate;
    }
    
    public String getCruiseName()
    {   return cruiseName;
    }
    public void setCruiseName(String name)
    {   cruiseName = name;
    }
    
    public Date getReturnDate()
    {   return returnDate;
    }
    public void setReturnDate(Date date)
    {   returnDate = date;
    }
            
    public Port getDeparturePort()
    {   return departurePort;
    }
    public void setDeparturePort(Port port)
    {   departurePort = port;
    }
    
    public Ship getCruiseShip()
    {   return cruiseShip;
    }
    public void setCruiseShip(Ship ship)
    {   cruiseShip = ship;
    } 
    public double getCruiseTicketCost()
    {    return cruiseTicketCost;
    }
   
    public void addPortsOfCall(Cruise cruise,Port port)
    {
            cruise.portsOfCall.add(port);
        
    }
    public ArrayList<Port> getPortsOfCall()
    {
        return portsOfCall;
    }
    
    public void addCruisePassengers(Passenger passenger)
    {
        cruisePassengers.add(passenger);
        
    }
    public ArrayList<Passenger> getCruisePassengers()
    {
        return cruisePassengers;
    } 
            
    public void addCruiseSailors(Sailor sailor)
    {
        cruiseSailors.add(sailor);
        
    }
    public ArrayList<Sailor> getCruiseSailors()
    {
        return cruiseSailors;
    }
    public void printCruiseDetails(Cruise cruise)
    {
         System.out.format("%-30s%s\n","Cruise Number:",cruise.getCruiseSerialNumber());
         System.out.format("%-30s%s\n","Cruise Name:",cruise.getCruiseName());
         System.out.format("%-30s%s\n","Cruise Sail in Date:", cruise.getSailinDate());
         System.out.format("%-30s%s\n","Cruise Return Date:", cruise.getReturnDate());
         System.out.format("%-30s%s\n","Cruise Depart Port:", cruise.getDeparturePort().getPortName());
         System.out.format("%-30s%s\n","Cruise ship:", cruise.getCruiseShip().getShipName());
         System.out.format("%-30s%s\n","Cruise Ticket Cost:", cruise.getCruiseTicketCost());
         ArrayList<String> portsNamez = new ArrayList<String>();
         for (Port i : getPortsOfCall())
         {
             portsNamez.add(i.getPortName());
         }
         System.out.format("%-30s%s\n","Cruise Intermediate Ports:", portsNamez);
         ArrayList<String> passengersNamez = new ArrayList<String>();
         for (Passenger i: getCruisePassengers())
         {
             passengersNamez.add(i.getPassengerName());
         }
         System.out.format("%-30s%s\n","Cruise Passengers:", passengersNamez);
         ArrayList<String> sailorNamez = new ArrayList<String>();
         for (Sailor i: getCruiseSailors())
         {
             sailorNamez.add(i.getSailorName()+ "-" + i.getSailorOccupation());
         }
         System.out.format("%-30s%s\n","Cruise Sailors:", sailorNamez);
    }
    public String toString()
    {
        String returnString ="";
        returnString = returnString+ getCruiseSerialNumber() + ",";
        returnString = returnString+ getCruiseName() + ",";
        returnString = returnString+ getSailinDate() + ",";
        returnString = returnString+ getReturnDate() + ",";
        returnString = returnString+ getDeparturePort().getPortName();
        
        return returnString;
    }
}
