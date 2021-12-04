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
public class DayThree {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day three.
     */
    public DayThree() {
        try {
            //File myObj = new File("files/21/03/sample.txt");
            File myObj = new File("files/21/03/source.txt");
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
     * First part of day three.
     */
    public void partOne() {
        // Setup some vars
        int[] ones = new int[lines.get(0).length()];
        String gammaBinaryString = "";
        String epsilonBinaryString = "";
        // Loop the lines
        for(String line : lines) {
            for(int i = 0 ; i < line.length() ; i++) {
                // Count 1's per column
                if(line.charAt(i) == '1') {
                    ones[i]++;
                }
            }
        }
        // Convert to most occurence
        for(int i = 0 ; i < ones.length ; i++) {
            // Decide
            if(ones[i] > lines.size() / 2 ) {
                gammaBinaryString += "1";
                epsilonBinaryString += "0";
            } else if (ones[i] < lines.size() / 2 ){
                gammaBinaryString += "0";
                epsilonBinaryString += "1";
            } else {
                System.out.println("AH OH!!??");
            }
        }
        // Process results
        int gamma = Integer.parseInt(gammaBinaryString, 2);
        int epsilon = Integer.parseInt(epsilonBinaryString, 2);
        // Present the awnser.
        System.out.println(
            "2021 Day Three - Part One = Gamma:" + gamma + 
            " * Epsilon:" + epsilon +
            " = " + gamma * epsilon
        );
    }
    
    /**
     * Second part of day three.
     */
    public void partTwo() {
        // Setup some vars
        LinkedList<String> generatorList = (LinkedList) lines.clone();
        LinkedList<String> scrubberList = (LinkedList) lines.clone();
        for(int i = 0 ; i < lines.get(0).length() ; i++) {
            // Setup vars
            LinkedList<String> zeroes = new LinkedList();
            LinkedList<String> ones = new LinkedList();
            // Loop all generatorLines left and split
            for(String generatorLine : generatorList) {
                if(generatorLine.charAt(i) == '0') {
                    zeroes.add(generatorLine);
                } else if (generatorLine.charAt(i) == '1') { 
                    ones.add(generatorLine);
                }
            }
            // Decide which list to replace our previous list with
            if(ones.size() >= zeroes.size()) {
                generatorList = ones;
            } else {
                generatorList = zeroes;
            }
            // Check if we have stuff left to check first
            if(scrubberList.size() == 1) {
                continue;
            }
            // Scrubber stuff
            zeroes = new LinkedList();
            ones = new LinkedList();
            for(String scrubberLine : scrubberList) {
                if(scrubberLine.charAt(i) == '0') {
                    zeroes.add(scrubberLine);
                } else if (scrubberLine.charAt(i) == '1') { 
                    ones.add(scrubberLine);
                }
            }
            // Decide on which list
            if(zeroes.size() > ones.size()) {
                scrubberList = ones;
            } else {
                scrubberList = zeroes;
            }
        }
        // Process results
        int generator = Integer.parseInt(generatorList.getFirst(), 2);
        int scrubber = Integer.parseInt(scrubberList.getFirst(), 2);
        System.out.println(
            "2021 Day Three - Part Two = Generator:" + generator + 
            " * Scrubber:" + scrubber +
            " = " + generator * scrubber
        );
    }
}
