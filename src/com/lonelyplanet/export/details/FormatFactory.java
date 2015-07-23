package com.lonelyplanet.export.details;

import com.lonelyplanet.exception.CustomException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.sourceforge.stripes.util.ResolverUtil;

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
   public Format getFormat(Integer choice) throws CustomException
   {       
       Format foramt = null;       
       String className = getImplementedClasses().get(choice).toString();
       try {
       //get class name dynamically from UI and create an instance of it. 
       foramt = (Format)Class.forName(packageName+"."+className).newInstance();
       } catch (Exception ex) {
           throw new CustomException("Given class not found in database. ");
       }
       return foramt;
   }
   
   public static Map<Integer,String> getImplementedClasses()
    {
         Map<Integer,String> mapCollecion = new HashMap<Integer, String>();
         ResolverUtil<Format> resolver = new ResolverUtil<Format>();
            resolver.findImplementations(Format.class, "com.lonelyplanet.export.details");
            Set<Class<? extends Format>> classes = resolver.getClasses();            
            int counter = 1;
            for (Class<? extends Format> clazz : classes) {
                
            if(!clazz.getSimpleName().equals("Format"))
            {
            mapCollecion.put(counter, clazz.getSimpleName());            
            counter++;
            }
            }
        return mapCollecion;
    }
}
   
