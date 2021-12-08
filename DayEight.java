/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author simon
 */
public class DayEight {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day seven.
     */
    public DayEight() {
        try {
            //File myObj = new File("files/21/08/sample.txt");
            File myObj = new File("files/21/08/source.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /**
     * First part of day eight.
     */
    public void partOne() {
        // Setup some vars
        int count = 0;
        List outputValues = new ArrayList<String>();
        for(String line : lines) {
            String[] values = line.split(" \\| ");
            for(String number : values[1].split(" ")) {
                if(
                    number.length() == 2 || // 1
                    number.length() == 4 || // 4
                    number.length() == 3 || // 7
                    number.length() == 7    // 8
                ) {
                    count++;
                }
            }
        }
        System.out.println(
            "2021 Day Eight - Part One = Known numbers : " + count
        );
    }
    
    /**
     * Second part of day eight.
     */
    public void partTwo() {   
        System.out.println(
            "2021 Day Eight - Part Two = "
        );
    }
}
