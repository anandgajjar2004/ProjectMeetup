package com.lonelyplanet.export.details;

import com.lonelyplanet.pojo.Alien;

/**
 * @author Anand Gajjar
 * Required for Factory pattern. 
 * Format interface for common behaviour across application.  
 */
public interface Format {
    
    void generate(Alien alien);
    
}
