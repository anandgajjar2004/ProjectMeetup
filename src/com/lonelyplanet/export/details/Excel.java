/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonelyplanet.export.details;

import com.lonelyplanet.exception.CustomException;
import com.lonelyplanet.pojo.Alien;

/**
 *
 * @author Anand Gajjar
 */
public class Excel implements Format {

    @Override
    public void generate(Alien alien) throws CustomException {
        System.out.print("Implement Code for Excel Report");
    }
    
}
