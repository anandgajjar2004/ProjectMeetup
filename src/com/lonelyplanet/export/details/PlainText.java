package com.lonelyplanet.export.details;

import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.exception.CustomException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anand Gajjar
 */
public class PlainText implements Format {
    
    @Override
    public void generate(Alien alien) throws CustomException 
    {
        try 
        {
        PrintWriter writer = new PrintWriter("details.txt", "UTF-8");        
        writer.println("---------------------------------------------------------------------------------");  
        writer.println("|\t\t\t\t\t\t\t|");
        writer.println("---------------------------------------------------------------------------------");  
        writer.println("|\tCode Name\t:  |\t" + alien.getCodeName()+"\t\t\t|");
        writer.println("|\tBlood Color\t:  |\t" + alien.getBloodColor()+"\t\t\t|");
        writer.println("|\tHome Planet\t:  |\t " + alien.getHomePlanet()+"\t\t\t|");
        writer.println("|\tNo. of Antennas\t:  |\t  " + alien.getNoOfAntennas()+"\t\t\t|");
        writer.println("|\tNo. of Legs\t:  |\t" + alien.getNoOfLegs()+"\t\t\t|");        
        writer.println("---------------------------------------------------------------------------------");  
        writer.close();        
        } catch (Exception ex) {
             throw new CustomException("There is some issue with PDF generate process. please contact to admin.");
        }
    }
    
}
