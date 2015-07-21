package com.lonelyplanet.export.details;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.exception.CustomException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anand Gajjar
 */
public class PlainText implements Format {
    
    /**
    *Implementation for Plain text file using PrintWriter class.
    */   
    @Override
    public void generate(Alien alien) throws CustomException 
    {
        try 
        {
        PrintWriter writer = new PrintWriter("Permit_Form.txt", "UTF-8");        
        DateFormat ddMMMyy = new SimpleDateFormat("dd/MMM/yyyy");
        writer.println("---------------------------------------------------------------------------------------------");  
        writer.println("|\t\t Permit Form. Welcome to Incredible Earth \t\t|");
        writer.println("|\t\t\t "+ddMMMyy.format(new Date())+"  \t\t\t\t|");
        writer.println("---------------------------------------------------------------------------------------------");  
        writer.println("|\tCode Name\t:  |\t" + alien.getCodeName()+"\t\t\t\t|");
        writer.println("|\tBlood Color\t:  |\t" + alien.getBloodColor()+"\t\t\t\t|");
        writer.println("|\tHome Planet\t:  |\t" + alien.getHomePlanet()+"\t\t\t\t|");
        writer.println("|\tNo. of Antennas\t:  |\t" + alien.getNoOfAntennas()+"\t\t\t\t|");
        writer.println("|\tNo. of Legs\t:  |\t" + alien.getNoOfLegs()+"\t\t\t\t|");        
        writer.println("|\tNo. of Eyes\t:  |\t" + alien.getNoOfEyes()+"\t\t\t\t|");        
        writer.println("|\tNo. of Nose\t:  |\t" + alien.getNoOfNose()+"\t\t\t\t|");        
        writer.println("|\tNo. of Days\t:  |\t" + alien.getNoOfDays()+"\t\t\t\t|");        
        writer.println("---------------------------------------------------------------------------------------------");  
        writer.close();        
        } catch (Exception ex) {
             throw new CustomException("There is some issue with PDF generate process. please contact to admin.");
        }
    }
    
}
