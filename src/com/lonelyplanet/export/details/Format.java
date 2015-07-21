package com.lonelyplanet.export.details;

import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.exception.CustomException;

/**
 * @author Anand Gajjar
 * Required for Factory pattern. 
 * Format interface for common behaviour across application.  
 */
public interface Format {
    
    void generate(Alien alien) throws CustomException;
    
}
