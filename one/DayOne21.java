/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author simon
 */
public class DayOne21 {
    
    private int lineCount = 0;
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day one.
     */
    public DayOne21() {
        try {
            //File myObj = new File("files/21/01/sample.txt");
            File myObj = new File("files/21/01/source.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                this.lineCount++;
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
     * First part of day one.
     */
    public void partOne() {
        // Bunch of vars
        int previous = 0;
        int increases = 0;
        int decreases = 0;
        // Loop the lines
        for(int i = 0 ; i < this.lineCount ; i++) {
            int currentValue = Integer.parseInt(this.lines.get(i));
            // Escape first time
            if(previous != 0) {
                // check if it is a increase or decrease
                if(currentValue > previous) {
                    increases++;
                } else if (currentValue < previous) {
                    decreases++;
                } else {
                    System.out.println("Same result, this should not happen.");
                }
            }
            // update previous
            previous = currentValue;
        }
        // Present the awnser.
        System.out.println(
            "2021 Day One - Part One = Total increases : " + increases
        );
    }
    
    /**
     * Second part of day one.
     */
    public void partTwo() {
        // Bunch of vars
        int previous = 0;
        int increases = 0;
        int decreases = 0;
        // Loop the lines, start with on offset of 2
        for(int i = 2 ; i < this.lineCount ; i++) {
            // Calculate the current size
            int currentSize = 
                    Integer.parseInt(this.lines.get(i-2)) +
                    Integer.parseInt(this.lines.get(i-1)) +
                    Integer.parseInt(this.lines.get(i));
            // Escape first time 
           if(previous != 0) {
                // check if it is a increase or decrease, skip duplicate sizes
                if(currentSize > previous) {
                    increases++;
                } else if (currentSize < previous) {
                    decreases++;
                }
            }
            // update previous
            previous = currentSize;
        }
        // Present the awnser.
        System.out.println(
            "2021 Day One - Part Two = Total increases : " + increases
        );
    }
}
