package com.lonelyplanet.export.details;

/**
 *
 * @author Anand Gajjar
 * FormatFactory class is to take input from user and based on selection create instance of PDF or Plain Text or etc..
 */
public class FormatFactory {
    
      //use getShape method to get object of type shape 
   public Format getFormat(String shapeType){
      if(shapeType == null){
         return null;
      }		
      
      //if user pass  choice 1 then create instance of PDF
      if(shapeType.equalsIgnoreCase("1")){
         return new PDF();
         
       //if user pass  choice 2 then create instance of Plain Text
      } else if(shapeType.equalsIgnoreCase("2")){
         return new PlainText();
      }
      return null;
   }
}
   
