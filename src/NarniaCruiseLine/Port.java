/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NarniaCruiseLine;

/**
 * This is a class for Ports it has portName,portCountry, portPopulation,portPassportRequired, dockingFee
 * to represent various attributes of a port,
 * it has get and set methods for all the private variables, printPortDetails() to print the details of a port object,
 * toString() to convert port Object into a string
 * @author VinayaSaiD
 */
public class Port {
    private String portName;
    String portCountry;
    private int portPopulation;
    private boolean portPassportRequired;
    public int dockingFee;
    
    // default constructor
    public Port()
    {
    }
    
    public Port(String name, String country, int population, boolean passport )
    {
        setPortName(name);
        portCountry = country;
        setPortPopulation(population);
        setPortPassportRequired(passport);
    }
    
    public String getPortName()
    {   return portName;
    }
    public void setPortName(String name)
    {   portName = name;
    }
    
    public int getPortPopulation()
    {   return portPopulation;
    }
    public void setPortPopulation(int population)
    {   portPopulation = population;
    }
    
    public boolean getPortPassportRequired()
    {   return portPassportRequired;
    }
    public void setPortPassportRequired(boolean passport)
    {   portPassportRequired = passport;
    }
    
    public int getDockingFee(double shipWeight)
    {
        if (shipWeight < 30000)
        {   dockingFee = 20000;
            return dockingFee;
        }
        if (shipWeight > 30000 && shipWeight < 50000)
        {   dockingFee = 50000;
            return dockingFee;
        }
        if (shipWeight > 50000)
        {   dockingFee = 100000;
            return dockingFee;
        }
        return 0;
    }
    
    public static void printPortDetails(Port port)
    {
        System.out.println("Port Name:" + port.getPortName());
        System.out.println("Port Country:" + port.portCountry);
        System.out.println("Port Population:" + port.getPortPopulation());
        System.out.println("Port Passport Required:" + port.getPortPassportRequired());
    }
    public String toString()
    {
        String returnString ="";
        returnString = returnString+ getPortName() + ",";
        returnString = returnString+ portCountry + ",";
        returnString = returnString+ getPortPopulation() + ",";
        returnString = returnString+ getPortPassportRequired();
        
        return returnString;
    }
}
