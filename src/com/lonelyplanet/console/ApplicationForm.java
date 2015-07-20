package com.lonelyplanet.console;

import com.lonelyplanet.pojo.Alien;
import com.itextpdf.text.DocumentException;
import com.lonelyplanet.export.details.Format;
import com.lonelyplanet.export.details.FormatFactory;
import com.lonelyplanet.export.details.PDF;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anand Gajjar
 */
public class ApplicationForm {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) 
     {
         System.out.println("Welcome to Project Meetup.");
         Scanner scan = new Scanner(System.in);
         
         System.out.println("Please enter Username: ");         
         String username = scan.nextLine();
         
         System.out.println("Please enter Password: ");         
         String password = scan.nextLine();
         
         if(username.equals("project") && password.equals("meetup"))
         {
             System.out.println("Successfully Authenticated.");         
             System.out.println("Please provide below details.");         
             
             Alien alien = new Alien();
             System.out.println("Code Name : ");
             alien.setCodeName(scan.nextLine());
             
             System.out.println("Blood Color : ");
             alien.setBloodColor(scan.nextLine());
             
             System.out.println("No. of Antennas : ");
             alien.setNoOfAntennas(Integer.parseInt(scan.nextLine()));
             
             System.out.println("No. of Legs : ");
             alien.setNoOfLegs(Integer.parseInt(scan.nextLine()));
             
             System.out.println("Home Planet : ");
             alien.setHomePlanet(scan.nextLine());
             
            System.out.println("Entry Successfully created.");         
            System.out.println("Please choose any below option to export data.");
            
            System.out.println("Press 1 for PDF format.");
            System.out.println("Press 2 for Plain Text format.");
            
            FormatFactory formatFactory = new FormatFactory();
            
            
            String option = scan.nextLine();
            if(option.equals("1"))
            {
                Format format = formatFactory.getFormat(option);
                format.generate(alien);
            }
            if(option.equals("2"))
            {
                Format format = formatFactory.getFormat(option);
                format.generate(alien);
            }
         }
         else 
         {
            System.out.println("Authentication Failed.");             
         }
        
        
    }
    
}
