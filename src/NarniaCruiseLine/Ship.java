/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

/**
 * This is a class for Ships it has shipNumber,shipName, shipWeight,yearBuilt, passengerCapacity
 * to represent various attributes of a ship,
 * it has get and set methods for all the private variables, printShipDetails() to print the details of a ship object,
 * toString() to convert ship Object into a string
 * @author VinayaSaiD
 */
public class Ship {
    
    private long shipNumber;
    private String shipName;
    private double shipWeight;
    private int yearBuilt;
    public int passengerCapacity;
    
    // default constructor
    public Ship()
    {
    }
    
    // specific constructor to create a class instance with all variables given
    public Ship(long number, String name, double weight, int year, int capacity)
    {   setShipNumber(number);
        setShipName(name);
        setShipWeight(weight);
        setYearBuilt(year);
        passengerCapacity = capacity;
    }
    
    public long getShipNumber()
    {   return shipNumber;
    }
    public void setShipNumber(long number)
    {   shipNumber = number;
    }
    public String getShipName()
    {   return shipName;
    }
    public void setShipName(String name)
    {   shipName = name;
    }
    public double getShipWeight()
    {   return shipWeight;
    }
    public void setShipWeight(double weight)
    {   shipWeight = weight;
    }
    public int getPassengerCapacity()
    {   return passengerCapacity;
    }
    public void setPassengerCapacity(int capacity)
    {   passengerCapacity = capacity;
    }
    public int getYearBuilt()
    {   return yearBuilt;
    }
    public void setYearBuilt(int year)
    {   yearBuilt = year;
    }
    
    public void printShipDetails(Ship ship)
    {
        System.out.println("Ship Number:" + ship.getShipNumber());
        System.out.println("Ship Name:" + ship.getShipName());
        System.out.println("Ship Weight:" + ship.getShipWeight());
        System.out.println("Ship Year Built:" + ship.getYearBuilt());
        System.out.println("Ship Passenger Capacity:" + ship.passengerCapacity);
    }
    
    public String toString()
    {
        String returnString ="";
        returnString = returnString+ getShipNumber() + ",";
        returnString = returnString+ getShipName() + ",";
        returnString = returnString+ getShipWeight() + ",";
        returnString = returnString+ getYearBuilt() + ",";
        returnString = returnString+ passengerCapacity;
        
        return returnString;
    }
}
