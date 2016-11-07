/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.Date;

/**
 * This class extends the Sailor class which is used to create Captains,
 * it has overridden methods getSailorSalary() to give 300000 as the Captains salary and
 * getSailorOccupation() to give Captain as output.
 * @author VinayaSaiD
 */
public class Captain extends Sailor{
    // default no argument constructor
    public Captain()
    {
    }
    public Captain(long number, String name, Date date , String nationality, boolean isSuper, double money)
    {
        setSailorIdentificationNumber(number);
        setSailorName(name);
        setSailorDateOfBirth(date);
        setSailorNationality(nationality);
        isSupervisor = isSuper;
        setSailorMoneySpent(money);
        setSailorOccupation("Captain");
        supervisor = "-";

    }
    //another constructor for captain class
    public Captain(long number, String name, Date date, String nationality, boolean isSuper, double money, String supervisorPerson)
    {
        this(number,name,date,nationality,isSuper,money);
        supervisor = supervisorPerson;
    }
    
    public double getSailorSalary()
    {
        return 300000;
    }
    public String getSailorOccupation()
    {
        return "Captain";
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
