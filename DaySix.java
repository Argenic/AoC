/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author simon
 */
public class DaySix {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day six.
     */
    public DaySix() {
        try {
            //File myObj = new File("files/21/06/sample.txt");
            File myObj = new File("files/21/06/source.txt");
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
     * First part of day six.
     */
    public void partOne() {
        String line = lines.getFirst();
        String[] instructions = line.split(",");
        int[] birdsPerDay = new int[9];
        for(int i = 0 ; i < instructions.length ; i++) {
            int instruction = Integer.parseInt(instructions[i]);
            birdsPerDay[instruction]++;
        }
        for(int i = 0 ; i < 80 ; i++){
            int[] newBirdsPerDay = new int[9];
            // Handle day to day business
            for(int j = 1 ; j < birdsPerDay.length ; j++) {
                newBirdsPerDay[j - 1] = birdsPerDay[j];
            }
            // Handle day 0
            newBirdsPerDay[8] = birdsPerDay[0];
            newBirdsPerDay[6] += birdsPerDay[0];
            birdsPerDay = newBirdsPerDay;
        }
        int count = 0;
        for(int j = 0 ; j < birdsPerDay.length ; j++) {
            count += birdsPerDay[j];
        }
        // Present the awnser.
        System.out.println(
            "2021 Day Six - Part One = Amount of birds : " + count
        );
    }
    
    /**
     * Second part of day six.
     */
    public void partTwo() {   
        String line = lines.getFirst();
        String[] instructions = line.split(",");
        // Integer overloading took me a while over here -_-
        long[] birdsPerDay = new long[9];
        for(int i = 0 ; i < instructions.length ; i++) {
            int instruction = Integer.parseInt(instructions[i]);
            birdsPerDay[instruction]++;
        }
        for(int i = 0 ; i < 256 ; i++){
            long[] newBirdsPerDay = new long[9];
            // Handle day to day business
            for(int j = 1 ; j < birdsPerDay.length ; j++) {
                newBirdsPerDay[j - 1] = birdsPerDay[j];
            }
            // Handle day 0
            newBirdsPerDay[8] = birdsPerDay[0];
            newBirdsPerDay[6] += birdsPerDay[0];
            birdsPerDay = newBirdsPerDay;
        }
        long count = 0;
        for(int j = 0 ; j < birdsPerDay.length ; j++) {
            // Strange casting that could be smarter..
            count += birdsPerDay[j];
        }
        System.out.println(
            "2021 Day Six - Part Two = Amount of birds : " + count
        );
    }
}
