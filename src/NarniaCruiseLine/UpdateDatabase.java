/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import java.util.*;
import java.lang.*;
import java.text.*;
import static NarniaCruiseLine.NarniaCruiseLine.*;
import static NarniaCruiseLine.HelperClass.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * This class is used to read all the cruises and check for end date if the cruise is done, save the entire cruise details to a file.
 * @author VinayaSaiD
 */
public class UpdateDatabase {
    public static void savingFiles() throws Exception
    {
        for (int j=0; j < (cruisePresent.size()-1);j++)
        {
            if (cruisePresent.get(j).getReturnDate().before(new Date()))
            {
                writeCruiseToFile(cruisePresent.get(j));
            }
        }
    }
    public static void writeCruiseToFile(Cruise cruiseToSave) throws Exception 
    {
        //java.io.File file = new java.io.File(fileName + ".txt");
        /*if (file.exists()) {
          System.out.println("File already exists");
          System.exit(0);
        }*/
        
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(cruiseToSave.getCruiseName() + ".txt")));
        
        output.format("%-30s%s\n","Cruise Number:",cruiseToSave.getCruiseSerialNumber());
        output.format("%-30s%s\n","Cruise Name:", cruiseToSave.getCruiseName());
        output.format("%-30s%s\n","Cruise Sail in Date:", cruiseToSave.getSailinDate());
        output.format("%-30s%s\n","Cruise Return Date:", cruiseToSave.getReturnDate());
        output.format("%-30s%s\n","Cruise Depart Port:", cruiseToSave.getDeparturePort().getPortName());
        output.format("%-30s%s\n","Cruise Ticket Cost:", cruiseToSave.getCruiseTicketCost());
        output.println();
        output.println("Cruise Ship Details");
        output.println();
        output.format("%-30s%s\n","Ship Name: ", cruiseToSave.getCruiseShip().getShipName());
        output.format("%-30s%s\n","Ship Number: ", cruiseToSave.getCruiseShip().getShipNumber());
        output.format("%-30s%s\n","Ship Year Built: ", cruiseToSave.getCruiseShip().getYearBuilt());
        output.format("%-30s%s\n","Ship Weight: ", cruiseToSave.getCruiseShip().getShipWeight());
        output.format("%-30s%s\n","Ship's Passenger Capacity: ", cruiseToSave.getCruiseShip().passengerCapacity);
        output.println();
        output.println("Intermediary Port Details");
        output.println("\n");
        output.format("%-20s%-30s%-20s%-20s%-20s\n","Port Name","Port Country","Port Population","Passport Required","Docking Fee");
        for (Port i : cruiseToSave.getPortsOfCall())
        {
            output.format("%-20s%-30s%-20s%-20s%-20s\n",i.getPortName(),i.portCountry,Integer.toString(i.getPortPopulation()),String.valueOf(i.getPortPassportRequired()),Double.toString(i.getDockingFee(cruiseToSave.getCruiseShip().getShipWeight())));
        }
        // evaluation forms
        for(int j =0;j<cruiseToSave.cruisePassengers.size();j++)
        {
            int[] randomArray = {randBetween(1,5),randBetween(1,5), randBetween(1,5), randBetween(1,5), randBetween(1,5)};
            cruiseToSave.cruisePassengers.get(j).setCruiseEvaluation(randomArray);
        }
        
        output.println("\n\n");
        output.println("Passengers Details");
        output.println();
        output.format("%-5s%-15s%-25s%-25s%-25s%-35s%-20s%-15s%-30s\n","S.No","Number","Name","Home Address","Nationality","Date of Birth","Money Paid","Money Spent","Evaluation");
        int serial = 1;
        for (Passenger i: cruiseToSave.getCruisePassengers())
        {
            output.format("%-5s%-15s%-25s%-25s%-25s%-35s%-20s%-15s%-30s\n",Integer.toString(serial),i.getPassengerNumber(),i.getPassengerName(),i.getHomeAddress(),i.getPassengerNationality(),i.getPassengerDateOfBirth(),i.getMoneyPaid(),i.getMoneySpent(),Arrays.toString(i.getCruiseEvaluation()));
            serial = serial +1;
        }
        
        output.println("\n\n");
        output.println("Employee Details");
        output.format("%-5s%-15s%-30s%-35s%-15s%-25s%-20s%-15s%-10s\n","S.No","ID Number","Sailor Name","Date of Birth","Salary","Nationality","Supervisor","Occupation","Money Spent");
        serial = 1;
        for (Sailor i: cruiseToSave.getCruiseSailors())
        {
            output.format("%-5s%-15s%-30s%-35s%-15s%-25s%-20s%-15s%-10s\n",Integer.toString(serial),i.getSailorIdentificationNumber(),i.getSailorName(),i.getSailorDateOfBirth(),i.getSailorSalary(),i.getSailorNationality(),i.supervisor,i.getSailorOccupation(),i.getSailorMoneySpent());
            serial = serial + 1;
        }

        // Close the file
        output.close();
    }
    
}
