package com.lonelyplanet.console;

import com.lonelyplanet.exception.CustomException;
import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.export.details.Format;
import com.lonelyplanet.export.details.FormatFactory;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anand Gajjar
 */
public class ApplicationForm {
    
    Scanner scan;
    
    public static void main(String args[])
    {
        try {
            new ApplicationForm().startApplication();
        } catch (CustomException ex) {
            Logger.getLogger(ApplicationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this method is starting point. call from main method. this method will intialize assets in future. as of now only welcome message.   
     public void startApplication() throws CustomException
     {
         System.out.println("-----------------------------------------------");
         System.out.println("Welcome to Project Meetup.");
         System.out.println("-----------------------------------------------");
         login();
     }
    
    /*
      authenticate user. take username and password as input from console and check weather user is valid or not. 
      if true then openRegistrationFrom or
      if fail then ask again to login
     */
     public void login() throws CustomException
     {        
         scan = new Scanner(System.in);
         
         
         //take inupt from the user. 
         System.out.println("Please enter Username: ");         
         String username = scan.nextLine();
         
         System.out.println("\nPlease enter Password: ");         
         String password = scan.nextLine();
         
         
         //configured username and password for working flow
         if(username.equals("project") && password.equals("meetup"))
         {
             //if true then call registration form.
             System.out.println("\n-----------------------------------------------");
             System.out.println("Successfully Authenticated.");         
             System.out.println("-----------------------------------------------\n");
             openRegistrationForm();
         }
         else
         {
             //if fail then call login method again.
              System.out.println("\n-----------------------------------------------");
              System.out.println("Authentication Failed.");         
              System.out.println("-----------------------------------------------\n");
              login();
         }
     }
         
     /*
      this method will intialize and render form on console screen and ask user to enter alien's data.       
     */
     public void openRegistrationForm() throws CustomException 
     {
             System.out.println("\n\nPlease provide below details.");         
             
             //Create object of alien, take input from user and fill business object
             Alien alien = new Alien();
             System.out.println("\nCode Name : ");
             alien.setCodeName(scan.nextLine());
             
             System.out.println("\nBlood Color : ");
             alien.setBloodColor(scan.nextLine());
             
             System.out.println("\nNo. of Antennas : ");
             alien.setNoOfAntennas(Integer.parseInt(scan.nextLine()));
             
             System.out.println("\nNo. of Legs : ");
             alien.setNoOfLegs(Integer.parseInt(scan.nextLine()));
             
             System.out.println("\nNo. of Nose : ");
             alien.setNoOfNose(Integer.parseInt(scan.nextLine()));
             
             System.out.println("\nNo. of Eyes : ");
             alien.setNoOfEyes(Integer.parseInt(scan.nextLine()));
             
             System.out.println("\nHome Planet : ");
             alien.setHomePlanet(scan.nextLine());
             
             System.out.println("\nFor how many days?");
             alien.setNoOfDays(Integer.parseInt(scan.nextLine()));
             
             System.out.println("\n-----------------------------------------------");
             System.out.println("Entry Successfully created.");         
             System.out.println("-----------------------------------------------\n\n");
             
             
            //after giving detials. console will promt user to enter choice for export data. 
            System.out.println("\nPlease choose any below option to export data.\n");
            
            System.out.println("Press 1 for PDF format.");
            System.out.println("Press 2 for Plain Text format.");
            
            FormatFactory formatFactory = new FormatFactory();
            
            String option = scan.nextLine();
            //based on user's choice, call getFormat method and pass option. 
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
            
             System.out.println("\n-----------------------------------------------");
             System.out.println("Data Exported Successfully in Current Directory.");         
             System.out.println("-----------------------------------------------\n\n");
             
             System.out.println("\nYou wan to continue or exit ?\n");
            
             System.out.println("Press 1 for Exit.");
             System.out.println("Press 2 for Continue.");
             option = scan.nextLine();
             
             if(option.equals("1"))
             {
                 System.exit(0);
             }
             else
             {
                 //if user wants to coninue then call openRegistrationForm() method again. 
                 openRegistrationForm();
             }
         }
    }
