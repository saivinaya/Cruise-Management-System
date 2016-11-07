/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;
import NarniaCruiseLine.HelperClass.*;
/**
 * This is the superclass of all the sailors it has sailoridentificationNumber,sailorName, sailorDateOfBirth,sailorSalary
 * sailorNationality, isSupervisor, sailorMoneySpent, sailorOccupation, supervisor to represent various attributes of a sailor,
 * it has get and set methods for all the private variables, printSailorDetails() to print the details of a sailor,
 * toString() to convert sailor Object into a string
 * @author VinayaSaiD
 */
public class Sailor {
    private long sailoridentificationNumber;
    private String sailorName;
    private Date sailorDateOfBirth;
    private double sailorSalary;
    private String sailorNationality;
    boolean isSupervisor;
    private double sailorMoneySpent;
    private String sailorOccupation;
    String supervisor;
    
    //default constructor 
    public Sailor()
    {   sailorSalary = 50000;
    }
    
    // specific constructor for defining the variables when a class reference is created
    public Sailor(long number, String name, Date date , String nationality, boolean isSuper, double money, String occupation)
    {
        setSailorIdentificationNumber(number);
        setSailorName(name);
        setSailorDateOfBirth(date);
        setSailorNationality(nationality);
        isSupervisor = isSuper;
        setSailorMoneySpent(money);
        setSailorOccupation(occupation);
        supervisor = "-";
        
    }
    public Sailor(long number, String name, Date date, String nationality, boolean isSuper, double money, String occupation, String supervisorPerson)
    {
        this(number,name,date,nationality,isSuper,money,occupation);
        supervisor = supervisorPerson;
    }
    
    public long getSailorIdentificationNumber()
    {   return sailoridentificationNumber;
    }
    public void setSailorIdentificationNumber(long number)
    {   sailoridentificationNumber = number;
    }
    
    public String getSailorName()
    {   return sailorName;
    }
    public void setSailorName(String name)
    {   sailorName = name;
    }
    
    public Date getSailorDateOfBirth()
    {   return sailorDateOfBirth;
    }
    public void setSailorDateOfBirth(Date date)
    {   sailorDateOfBirth = date;
    }
   
    public String getSailorNationality()
    {   return sailorNationality;
    }
    public void setSailorNationality(String nationality)
    {   sailorNationality = nationality;
    }
    
    public double getSailorMoneySpent()
    {   return sailorMoneySpent;
    }
    public void setSailorMoneySpent(double money)
    {   sailorMoneySpent = money;
    }
    
    public void setSailorSalary(double salary)
    {   sailorSalary = salary;
    }
    public double getSailorSalary()
    {
        return 50000;
    }
    
    public void setSailorOccupation(String occupation)
    {
        sailorOccupation = occupation;
    }
    public String getSailorOccupation()
    {
        return "Sailor";
    }
    public void printSailorDetails(Sailor sailor)
    {
        System.out.println("Sailor Identification Number:" + sailor.getSailorIdentificationNumber());
        System.out.println("Sailor Name:" + sailor.getSailorName());
        System.out.println("Sailor Date of Birth:" + sailor.getSailorDateOfBirth());
        System.out.println("Sailor Salary:" + sailor.getSailorSalary());
        System.out.println("Sailor Nationality:" + sailor.getSailorNationality());
        System.out.println("Sailor Money Spent:" + sailor.getSailorMoneySpent());
        System.out.println("Sailor is Spervisor:" + sailor.isSupervisor);
        System.out.println("Sailor Money Spent:" + sailor.supervisor);
    }
    
    public String toString()
    {
        String returnString ="";
        returnString = returnString+ getSailorIdentificationNumber() + ",";
        returnString = returnString+ getSailorName() + ",";
        returnString = returnString+ HelperClass.dateToString(getSailorDateOfBirth()) + ",";
        returnString = returnString+ getSailorNationality() + ",";
        returnString = returnString+ isSupervisor + ",";
        returnString = returnString+ getSailorMoneySpent() + ",";
        returnString = returnString+ supervisor;
        
        return returnString;
    }
    
}
