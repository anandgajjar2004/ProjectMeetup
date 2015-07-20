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
        Alien a = new Alien();
         
        System.out.println("Yout Name : ?");
        Scanner scan = new Scanner(System.in);
   //     a.setName(scan.nextLine());
        
        System.out.println("From which planet : ?");
        scan = new Scanner(System.in);
     //   a.setPlanetName(scan.nextLine());
        
        System.out.println("Which format you want to see ?");
        scan = new Scanner(System.in);
                       
        FormatFactory formatFactory = new FormatFactory();
        Format format = formatFactory.getFormat(scan.nextLine());
        format.generate(a);
        
        
    }
    
}
