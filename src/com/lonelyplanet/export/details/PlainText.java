/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonelyplanet.export.details;

import com.lonelyplanet.pojo.Alien;
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
    public void generate(Alien alien) 
    {
        try 
        {
        PrintWriter writer = new PrintWriter("details.txt", "UTF-8");        
        writer.println("---------------------------------------------------------------------------------");  
        writer.println("|                                                                               |");
        writer.println("---------------------------------------------------------------------------------");  
        writer.println("|\tCode Name\t:  |  \t" + alien.getCodeName()+"      \t\t\t|");
        writer.println("|\tBlood Color\t:  |  \t" + alien.getBloodColor()+"   \t\t\t|");
        writer.println("|\tHome Planet\t:  | \t " + alien.getHomePlanet()+"    \t\t\t|");
        writer.println("|\tNo. of Antennas\t:  |\t  " + alien.getNoOfAntennas()+" \t\t\t|");
        writer.println("|\tNo. of Legs\t:  |  \t" + alien.getNoOfLegs()+"      \t\t\t|");        
        writer.println("---------------------------------------------------------------------------------");  
        writer.close();        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlainText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PlainText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
