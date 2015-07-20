/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonelyplanet.export.details;

/**
 *
 * @author Anand Gajjar
 */
public class FormatFactory {
    
      //use getShape method to get object of type shape 
   public Format getFormat(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("PDF")){
         return new PDF();
         
      } else if(shapeType.equalsIgnoreCase("PlainText")){
         return new PlainText();
         
      }
      
      return null;
   }
}
   
