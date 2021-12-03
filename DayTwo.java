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
public class DayTwo {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day two.
     */
    public DayTwo() {
        try {
            //File myObj = new File("files/21/02/sample.txt");
            File myObj = new File("files/21/02/source.txt");
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
     * First part of day two.
     */
    public void partOne() {
        // Setup some vars
        int depth = 0;
        int position = 0;
        // Loop the lines
        for(String line : lines) {
            String[] instruction = line.split(" ");
            String operator = instruction[0];
            int value = Integer.parseInt(instruction[1]);
            // Decide the action based on the operator
            switch(instruction[0]) {
                case "forward" :
                    position += value;
                    break;
                case "up" :
                    depth -= value;
                    break;
                case "down" :
                    depth += value;
                    break;
                default :
                    System.out.println("Something went wrong : " + instruction[0]);
            }
        }
        // Calculate the resulting 'number'
        int result = depth * position;
        // Present the awnser.
        System.out.println(
            "2021 Day Two - Part One = Depth:" + depth + 
            " * Position:" + position +
            " = " + result
        );
    }
    
    /**
     * Second part of day two.
     */
    public void partTwo() {
        // Setup some vars
        int depth = 0;
        int position = 0;
        int aim = 0;
        // Loop the lines
        for(String line : lines) {
            String[] instruction = line.split(" ");
            String operator = instruction[0];
            int value = Integer.parseInt(instruction[1]);
            // Decide the action based on the operator
            switch(instruction[0]) {
                case "forward" :
                    position += value;
                    depth += aim * value;
                    break;
                case "up" :
                    aim -= value;
                    break;
                case "down" :
                    aim += value;
                    break;
                default :
                    System.out.println("Something went wrong : " + instruction[0]);
            }
        }
        // Calculate the resulting 'number'
        int result = depth * position;
        // Present the awnser.
        System.out.println(
            "2021 Day Two - Part Two = Depth:" + depth + 
            " * Position:" + position +
            " = " + result
        );
    }
}
