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
        writer.println("-------------------------------------");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("|  Name :  | " + alien.getName()+"  |");
//        writer.println("-------------------------------------");
  //      writer.println(alien.getPlanetName());
        writer.close();        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlainText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PlainText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
