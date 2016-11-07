/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import static NarniaCruiseLine.Cruise.*;
import java.net.URL;
/**
 * this class contains the methods which are used in the entire project to do certain necessary tasks;
 * randomDateofBirth() is used to generate a random date of birth,
 * makeDateFromString() is used to convert a string into a date format,
 * randomDate() is used to generate a date in the future from today,
 * randomEndDate() is used to create a date of return for the cruise which is between 3 to 15 days from the start of the cruise,
 * randBetween() is used to get a random number between two values inclusive of both numbers,
 * randNumber() is used to get a random 7 digit number ,
 * randSailorID() is used to get a random 9 digit number,
 * printCruisePresent() is used to get all the cruise that are maintained by the cruise lines,
 * readNamesFile() is used to read the names, cities and countries,
 * readFile() is used to read any file line by line,
 * appendToFile() is used to append the new sailors, passengers, ship and other entities back to the respective text files,
 * writeCruiseToFile() is used to generate the text files with all the cruise information once the cruise is done,
 * dateToString() is used to covert the date to string in dd/MM/yyyy format.
 * @author VinayaSaiD
 */
public class HelperClass {
    
    public static ArrayList<String> personNames = new ArrayList<String>();
    public static ArrayList<String> countryNames = new ArrayList<String>();
    public static ArrayList<String> addressNames = new ArrayList<String>();
            
    public static Date randomDateofBirth() 
    {
        int year = HelperClass.randBetween(1930, 2011);// range of years, keeping it within 85 years
        int month = HelperClass.randBetween(0, 11);

        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = HelperClass.randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(year, month, day);

        return (gc.getTime());

    }
    
    public static Date makeDateFromString(String dateString) 
    {
        String[] dateParts = dateString.split("-");
        int year = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[1]);

        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = Integer.parseInt(dateParts[0]);
        if (day <= gc.getActualMaximum(gc.DAY_OF_MONTH))
        {
            gc.set(year, month, day);
        }
        return (gc.getTime());

    }
    
    public static Date randomDate() 
    {
        int year = HelperClass.randBetween(2017, 2019); //range of years in the future
        int month = HelperClass.randBetween(0, 11); // from october month 2016
        int hour = HelperClass.randBetween(0, 23); //Hours will be displayed in between 0 to 23
        int min = HelperClass.randBetween(0, 59);

        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = HelperClass.randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(year, month, day, hour, min);

        return (gc.getTime());

    }
    
    public static Date randomEndDate(Date date) 
    {
        int daysMore = randBetween(3,15);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        cal.add(Calendar.DATE, daysMore);
        return (cal.getTime());

    }

    public static int randBetween(int start, int end) 
    {   return start + (int)Math.round(Math.random() * (end - start));
    }
    
    // length of 7 digits used for ship and cruise number`
    public static long randNumber()
    {
        long start = 1000000;
        long end = 9999999;
        return (long) start +  Math.round(Math.random() * (long) (end - start));
    }
    
    //length of 9 digits used for SailorID
    public static long randSailorID()
    {
        long start = 100000000;
        long end = 999999999;
        return start + (long) Math.round(Math.random() * (long)(end - start));
    }
    
    public static void printCruisePresent()
    {
        System.out.println("\nCruise Present are:");
        System.out.format("%-5s%-20s%-20s%-35s%-35s%-30s%-20s\n","S.No","Cruise Number","Cruise Name","Start Date","End Date","Start Port","Ticket Cost");
        int serial = 1;
        for (Cruise i :NarniaCruiseLine.cruisePresent)
        {
            System.out.format("%-5s%-20s%-20s%-35s%-35s%-30s%-20s\n",Integer.toString(serial),i.getCruiseSerialNumber(),i.getCruiseName(),i.getSailinDate(),i.getReturnDate(),i.getDeparturePort().getPortName(),Double.toString(i.getCruiseTicketCost()));
            serial = serial +1;
        }
    }
    
    public static void readNamesFile(String name) throws Exception
    {       InputStream s = HelperClass.class.getResourceAsStream("/Database/"+name);
            // Create a File instance
            System.out.println(s);
            Scanner read = new Scanner(s);
            read.useDelimiter(",");
            
            String names;
            // Read data from a file
            while (read.hasNext()) {
              names = read.nextLine();
              //System.out.println(Arrays.toString(names));
              personNames.add(names.split(",")[0]);
              countryNames.add(names.split(",")[1]);
              addressNames.add(names.split(",")[2]);

            }
            // Close the file
            read.close();
  }
    public static ArrayList<String> readFile(String name) throws Exception
    {
            InputStream s = HelperClass.class.getResourceAsStream("/Database/"+name);
            // Create a File instance
            Scanner read = new Scanner(s);
            read.useDelimiter(",");
            
            ArrayList<String> lines = new ArrayList<String>();
            String names;
            // Read data from a file
            while (read.hasNext()) {
              names = read.nextLine();
              lines.add(names);
              
            }
            // Close the file
            read.close();
            return lines;
    }
    
    public static void appendToFile(String data, String fileName) throws Exception 
    {
        //java.io.File file = new java.io.File(fileName + ".txt");
        /*if (file.exists()) {
          System.out.println("File already exists");
          System.exit(0);
        }*/
        
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        // Write formatted output to the file
        output.println(data);

        // Close the file
        output.close();
    }
    
    
    public static String dateToString(Date date)
    {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String reportDate = df.format(date);
    return reportDate;
    }
}

