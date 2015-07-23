package com.lonelyplanet.export.details;

import com.lonelyplanet.exception.CustomException;

/**
 *
 * @author Anand Gajjar
 * FormatFactory class is to take input from user and based on selection create instance of PDF or Plain Text or etc..
 */
public class FormatFactory {
    
    //get current package name;
    //value = com.lonelyplanet.export.details
    private String packageName = Format.class.getPackage().getName();
    
   //use getFormat method to get object of type shape 
   public Format getFormat(String className) throws CustomException
   {       
       Format foramt = null;       
       try {
       //get class name dynamically from UI and create an instance of it. 
       foramt = (Format)Class.forName(packageName+"."+className).newInstance();
       } catch (Exception ex) {
           throw new CustomException("Given class not found in database. ");
       }
       return foramt;
   }
}
   
