/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.Date;

/**
 * This class extends the Sailor class which is used to create Supervisor for Sailors,
 * it has overridden method getSailorSalary() to get the salary of a supervisor Sailor
 * toString() to get the supervisor Sailor object as a string
 * @author VinayaSaiD
 */
public class SuperSailor extends Sailor{
    
    // default no argument constructor
    public SuperSailor()
    {   double baseSalary = super.getSailorSalary();
        // 20 % extra compared to normal sailor
        double extra = 0.2 * baseSalary;
        setSailorSalary(baseSalary+extra);
    }
    
    // specific constructor for defining the variables when a class reference is created
    public SuperSailor(long number, String name, Date date , String nationality, double money)
    {
        setSailorIdentificationNumber(number);
        setSailorName(name);
        setSailorDateOfBirth(date);
        setSailorNationality(nationality);
        isSupervisor = true;
        setSailorMoneySpent(money);
        setSailorOccupation("SuperSailor");
        supervisor = "-";
    }
    public SuperSailor(long number, String name, Date date, String nationality, double money, String supervisorPerson)
    {
        this(number,name,date,nationality,money);
        supervisor = supervisorPerson;
    }
    
    public double getSailorSalary()
    {   double baseSalary = super.getSailorSalary();
        // 20 % extra compared to normal sailor
        double extra = 0.2 * baseSalary;
        return (baseSalary+extra);
    }
    
    public String getSailorOccupation()
    {
        return "SuperSailor";
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
