/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;
import static NarniaCruiseLine.HelperClass.*;
/**
 * This is a class for Passengers it has passengerNumber,passengerName, homeAddress,passengerNationality, passengerDateOfBirth
 * moneyPaid, cruiseEvaluation, moneySpent to represent various attributes of a passenger,
 * it has get and set methods for all the private variables, printPassengerDetails() to print the details of a Passenger object,
 * toString() to convert Passenger Object into a string, and it implements
 * compareTo() method to implement the Comparable interface based on the moneySpent by the passengers
 * @author VinayaSaiD
 */
public class Passenger implements Comparable<Passenger>{
    private long passengerNumber;
    private String passengerName;
    private String homeAddress;
    private String passengerNationality;
    private Date passengerDateOfBirth;
    private double moneyPaid;
    private double moneySpent;
    private int[] cruiseEvaluation;
    
    // default constructor
    public Passenger()
    {
    }
    
    // specific constructor to create an instance with certain fields
    public Passenger(long number, String name, String address, String nationality, Date date, double money, double moneyspent)
    {
        setPassengerNumber(number);
        setPassengerName(name);
        setHomeAddress(address);
        setPassengerNationality(nationality);
        setPassengerDateOfBirth(date);
        setMoneyPaid(money);
        setMoneySpent(moneyspent);
    }
    
    public long getPassengerNumber()
    {   return passengerNumber;
    }
    public void setPassengerNumber(long number)
    {   passengerNumber = number;
    }
    
    public String getPassengerName()
    {   return passengerName;
    }
    public void setPassengerName(String name)
    {   passengerName = name;
    }
    
    public String getHomeAddress()
    {   return homeAddress;
    }
    public void setHomeAddress(String address)
    {   homeAddress = address;
    }
    
    public String getPassengerNationality()
    {   return passengerNationality;
    }
    public void setPassengerNationality(String nationality)
    {   passengerNationality = nationality;
    }
    
    public Date getPassengerDateOfBirth()
    {   return passengerDateOfBirth;
    }
    public void setPassengerDateOfBirth(Date date)
    {   passengerDateOfBirth = date;
    }
    
    public double getMoneyPaid()
    {   return moneyPaid;
    }
    public void setMoneyPaid(double money)
    {   moneyPaid = money;
    }
    
    public double getMoneySpent()
    {   return moneySpent;
    }
    public void setMoneySpent(double spent)
    {   moneySpent = spent;
    }

    public int[] getCruiseEvaluation()
    {   return cruiseEvaluation;
    }
    public void setCruiseEvaluation(int[] evaluation)
    {   cruiseEvaluation = evaluation;
    }
    
    public void printPassengerDetails(Passenger passenger)
    {
        System.out.println("Passenger Number:" + passenger.getPassengerNumber());
        System.out.println("Passenger Name:" + passenger.getPassengerName());
        System.out.println("Passenger Address:" + passenger.getHomeAddress());
        System.out.println("Passenger Nationality:" + passenger.getPassengerNationality());
        System.out.println("Passenger Date of Birth:" + passenger.getPassengerDateOfBirth());
        System.out.println("Passenger Money Paid:" + passenger.getMoneyPaid());
        System.out.println("Passenger Money Spent:" + passenger.getMoneySpent());
    }
    
    public int compareTo(Passenger comparePassenger) 
    {
        double compareQuantity = comparePassenger.getMoneySpent();
        //ascending order
        //return (int) (this.getMoneySpent() - compareQuantity);
        //descending order
        return (int)(compareQuantity - this.getMoneySpent());
    }
    
    public String toString()
    {
        String returnString ="";
        returnString = returnString+ getPassengerNumber() + ",";
        returnString = returnString+ getPassengerName() + ",";
        returnString = returnString+ getHomeAddress() + ",";
        returnString = returnString+ HelperClass.dateToString(getPassengerDateOfBirth()) + ",";
        returnString = returnString+ getPassengerNationality() + ",";
        returnString = returnString+ getMoneyPaid() + ",";
        returnString = returnString+ getMoneySpent() ;
        
        return returnString;
    }
}
