/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

import static NarniaCruiseLine.NarniaCruiseLine.*;
import static NarniaCruiseLine.HelperClass.*;
import static NarniaCruiseLine.CreateCruise.*;
import java.util.*;

/**
 * This class is used to get a generate a report for a particular Cruise selected by the passenger,
 * create() is used to take the cruise from the user and calls the other methods to generate the report,
 * revenueGeneratedFromCruise()  is used to get Revenue generated from the cruise passengers by nationality,
 * printSailorDetailsOfACruise() is used to get Details of Sailors and the cost of paying their salaries and the cost of docking at different ports,
 * printPassengersOfACruise() is used to get List of passengers with their details sorted by moneySpentOnCruise,
 * printCruiseEvaluation() is used to get Cruise evaluation by passengers,
 * printShipprofit() is used to get Ships Revenue and Expenditure
 * @author VinayaSaiD
 */
public class CruiseReport {
    public static void create() throws Exception
    { 
        printCruisePresent();
        
        Scanner input = new Scanner(System.in); 
        int cruisePosition = 0;
        boolean wrongInput = true;
        while(wrongInput == true)
        {   
            System.out.println("\nPlease choose the Cruise to get the Report:"); 
            int cruiseListLength = NarniaCruiseLine.cruisePresent.size();
            cruisePosition = input.nextInt();
            for(int a=1; a <= cruiseListLength;a++)
            {
                if (cruisePosition == a)
                {   wrongInput = false;
                }
            }
            if (wrongInput == true)
            {
                {   System.out.println("\nWrong input entered. \n");
                }
            }
        }
        int cruiseIdex = cruisePosition -1;
        Cruise cruiseSelected = cruisePresent.get(cruiseIdex);
        System.out.println("\nDetailed Cruise Report\n");
        System.out.println("Report 1\n\nRevenue generated from the cruise passengers by nationality");
        revenueGeneratedFromCruise(cruiseSelected);
        System.out.println("\nReport 2\nDetails of Sailors and the cost of paying their salaries and the cost of docking at different ports");
        double[] totalShipExpenses = printSailorDetailsOfACruise(cruiseSelected);
        System.out.println("\nReport 3\nList of passengers with their details sorted by moneySpentOnCruise");
        double totalMoneyPassengers = printPassengersOfACruise(cruiseSelected);
        System.out.println("\nReport 4\nCruise evaluation by passengers");
        printCruiseEvaluation(cruiseSelected);
        System.out.println("\nReport 5\nShips Revenue & Expenditure");
        printShipprofit(cruiseSelected,totalShipExpenses,totalMoneyPassengers);
        UpdateDatabase.savingFiles();
    }
    
    public static void revenueGeneratedFromCruise(Cruise cruise)
    {
        ArrayList<Integer> PassengerAge = new ArrayList<Integer>();
        Calendar cal = Calendar.getInstance();
        ArrayList<String> PassengerNationality = new ArrayList<String>();
        for (int i=0; i < cruise.cruisePassengers.size();i++)
        {
            
            PassengerNationality.add(cruise.cruisePassengers.get(i).getPassengerNationality());
        }
        System.out.format("%-30s%-20s\n","Nationality of Passengers","Revenue Generated");
        for (int k =0; k< PassengerNationality.size(); k++)
        {   double sumrevenue = 0;
            for (int l=0; l< cruise.cruisePassengers.size();l++)
            {   
                if(cruise.cruisePassengers.get(l).getPassengerNationality() == PassengerNationality.get(k))
                {
                    sumrevenue = sumrevenue + cruise.cruisePassengers.get(l).getMoneyPaid() + cruise.cruisePassengers.get(l).getMoneySpent() ;
                }
            }
            System.out.format("%-30s%-20s\n",PassengerNationality.get(k),sumrevenue);
        }
    }
    public static double[] printSailorDetailsOfACruise(Cruise cruise)
    {
        System.out.println("\nSailors present on the Cruise(" + cruise.getCruiseName() +") are:");
        System.out.format("%-5s%-15s%-25s%-35s%-15s%-25s%-20s%-15s%-10s\n","S.No","ID Number","Sailor Name","Date of Birth","Salary","Nationality","Supervisor","Occupation","Money Spent");
        int serial = 1;
        double totalCostSalary = 0;
        double totalMoneyFromSailors = 0;
        for (Sailor k : cruise.cruiseSailors)
        {   String supervisor = "-";
            if (!(k.supervisor == null))
            {
                supervisor = k.supervisor;
            }
            totalCostSalary = totalCostSalary + k.getSailorSalary();
            totalMoneyFromSailors = totalMoneyFromSailors + k.getSailorMoneySpent();
            System.out.format("%-5s%-15s%-25s%-35s%-15s%-25s%-20s%-15s%-10s\n",Integer.toString(serial),k.getSailorIdentificationNumber(),k.getSailorName(),k.getSailorDateOfBirth(),k.getSailorSalary(),k.getSailorNationality(),supervisor,k.getSailorOccupation(),k.getSailorMoneySpent());
            serial = serial +1;
        }
        System.out.println("\nTotal Cost of paying the Employees on this Cruise is $" + totalCostSalary);
        double cruiseShipWeight = cruise.getCruiseShip().getShipNumber();
        double totalDockingFee = 0;
        for (Port l : cruise.portsOfCall)
        {
            totalDockingFee = totalDockingFee + l.getDockingFee(cruiseShipWeight);
        }
        System.out.println("\nTotal Cost of Docking for this Cruise is $" + totalDockingFee);
        double[] returnArray = {(totalCostSalary+totalDockingFee),totalMoneyFromSailors};
        return returnArray;
    }
    
    public static double printPassengersOfACruise(Cruise cruise)
    {
        System.out.println("\nPassengers present on the Cruise(" + cruise.getCruiseName() +") are:");
        System.out.format("%-5s%-15s%-25s%-25s%-25s%-35s%-20s%-15s\n","S.No","Number","Name","Home Address","Nationality","Date of Birth","Money Paid","Money Spent");
        Passenger array[] = new Passenger[cruise.cruisePassengers.size()];  
        double totalMoneyFromPassengers = 0;
        for(int j =0;j<cruise.cruisePassengers.size();j++)
        {
            int[] randomArray = {randBetween(1,5),randBetween(1,5), randBetween(1,5), randBetween(1,5), randBetween(1,5)};
            cruise.cruisePassengers.get(j).setCruiseEvaluation(randomArray);
            array[j] = cruise.cruisePassengers.get(j);
            totalMoneyFromPassengers = totalMoneyFromPassengers + cruise.cruisePassengers.get(j).getMoneyPaid() + cruise.cruisePassengers.get(j).getMoneySpent();
        }
        Arrays.sort(array);
        int serial = 1;
        for (Passenger k : array)
        {
            System.out.format("%-5s%-15s%-25s%-25s%-25s%-35s%-20s%-15s\n",Integer.toString(serial),k.getPassengerNumber(),k.getPassengerName(),k.getHomeAddress(),k.getPassengerNationality(),k.getPassengerDateOfBirth(),k.getMoneyPaid(),k.getMoneySpent());
            serial = serial +1;
        }
        return totalMoneyFromPassengers;
    }
    public static void printCruiseEvaluation(Cruise cruise)
    {
        System.out.println("\nCruise Evaluation by passengers on the Cruise(" + cruise.getCruiseName() +") are:");
        System.out.format("%-5s%-20s%-25s%-25s%-25s%-30s\n","S.No","Number","Name","Home Address","Nationality","Evaluation");
        Passenger array[] = new Passenger[cruise.cruisePassengers.size()];              
        for(int j =0;j<cruise.cruisePassengers.size();j++)
        {
            int[] randomArray = {randBetween(1,5),randBetween(1,5), randBetween(1,5), randBetween(1,5), randBetween(1,5)};
            cruise.cruisePassengers.get(j).setCruiseEvaluation(randomArray);
            array[j] = cruise.cruisePassengers.get(j);
        }
        Arrays.sort(array);
        int serial = 1;
        for (Passenger k : array)
        {
            System.out.format("%-5s%-20s%-25s%-25s%-25s%-30s\n",Integer.toString(serial),k.getPassengerNumber(),k.getPassengerName(),k.getHomeAddress(),k.getPassengerNationality(),Arrays.toString(k.getCruiseEvaluation()));
            serial = serial +1;
        }
    }
    public static void printShipprofit(Cruise cruise,double[] sailorMoney, double passengerMoney)
    {
        double totalRevenue = sailorMoney[1]+passengerMoney;
        System.out.println("\nThe Cruise(" + cruise.getCruiseName() +") Revenues: $ " + totalRevenue);
        System.out.println("\nThe Cruise(" + cruise.getCruiseName() +") Expenses: $ " + sailorMoney[0]);
        double profit = totalRevenue - sailorMoney[0];
        if (profit > 0)
        {   System.out.println("\nThe Cruise(" + cruise.getCruiseName() +") made a profit of: $ " + profit);
        }
        else
        {   profit = -profit;
            System.out.println("\nThe Cruise(" + cruise.getCruiseName() +") made a loss of: $ " + profit);   
        }
    }
}
