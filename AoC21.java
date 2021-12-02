/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import AoC.year21.one.DayOne21;
import AoC.year21.two.DayTwo21;

/**
 *
 * @author simon
 */
public class AoC21 {

    public void execute() {
        // Day One
        DayOne21 one21 = new DayOne21();
        one21.partOne();
        one21.partTwo();   
        
        // Day One
        DayTwo21 two21 = new DayTwo21();
        two21.partOne();
        two21.partTwo();  
    }
}
