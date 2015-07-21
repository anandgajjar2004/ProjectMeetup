package com.lonelyplanet.console;

import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.export.details.Format;
import com.lonelyplanet.export.details.FormatFactory;
import java.util.Scanner;

/**
 *
 * @author Anand Gajjar
 */
public class ApplicationForm {
    
    Scanner scan;
    
    public static void main(String args[])
    {
        new ApplicationForm().startApplication();
    }

    /**
     * @param args the command line arguments
     */
    
     public void startApplication()
     {
         System.out.println("-----------------------------------------------");
         System.out.println("Welcome to Project Meetup.");
         System.out.println("-----------------------------------------------");
         login();
     }
    
     public void login()
     {        
         scan = new Scanner(System.in);
         
         System.out.println("Please enter Username: ");         
         String username = scan.nextLine();
         
         System.out.println("Please enter Password: ");         
         String password = scan.nextLine();
         
         if(username.equals("project") && password.equals("meetup"))
         {
             System.out.println("-----------------------------------------------");
             System.out.println("Successfully Authenticated.");         
             System.out.println("-----------------------------------------------\n");
             openRegistrationFrom();
         }
         else
         {
              System.out.println("Authentication Failed.");         
              login();
         }
     }
         
    
     public void openRegistrationFrom() 
     {
             System.out.println("\n\nPlease provide below details.");         
             
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
             
             System.out.println("-----------------------------------------------");
             System.out.println("Entry Successfully created.");         
             System.out.println("-----------------------------------------------\n\n");
             
            System.out.println("Please choose any below option to export data.\n");
            
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
            
             System.out.println("-----------------------------------------------");
             System.out.println("Data Exported Successfully in Current Directory.");         
             System.out.println("-----------------------------------------------\n\n");
             
             System.out.println("You wan to continue or exit ?\n");
            
             System.out.println("Press 1 for Exit.");
             System.out.println("Press 2 for Continue.");
             option = scan.nextLine();
             
             if(option.equals("1"))
             {
                 System.exit(0);
             }
             else
             {
                 openRegistrationFrom();
             }
         }
    }
