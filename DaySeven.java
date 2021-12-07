/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author simon
 */
public class DaySeven {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day seven.
     */
    public DaySeven() {
        try {
            //File myObj = new File("files/21/07/sample.txt");
            File myObj = new File("files/21/07/source.txt");
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
     * First part of day seven.
     */
    public void partOne() {
        int[] startingValues = generateValues();
        int median = startingValues[startingValues.length/2];
        int fuelCount = 0;
        for(int value : startingValues) {
            fuelCount += Math.abs(value - median);
        }
        System.out.println(
            "2021 Day Seven - Part One = Fuel needed : " + fuelCount
        );
    }
    
    /**
     * Second part of day seven.
     */
    public void partTwo() {   
        System.out.println(
            "2021 Day Seven - Part Two = "
        );
    }    
    
    private int[] generateValues() {
        String[] stringValues = lines.getFirst().split(",");
        int[] startingValues = new int[stringValues.length];
        for(int i = 0 ; i < stringValues.length ; i++) {
            startingValues[i] = Integer.parseInt(stringValues[i]);
        }
        Arrays.sort(startingValues);
        return startingValues;
    }
}
