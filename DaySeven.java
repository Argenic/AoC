package AoC.year21;

import AoC.Day;
import java.util.Arrays;

public class DaySeven extends Day {

    public String fileLocation = "files/21/07/source.txt";
    //public String fileLocation = "files/21/07/sample.txt";
    
    public void partOne() {
        int[] startingValues = generateValues(false);
        int median = startingValues[startingValues.length/2];
        int fuelCount = 0;
        for(int value : startingValues) {
            fuelCount += Math.abs(value - median);
        }
        System.out.println(
            "2021 Day Seven - Part One = Fuel needed : " + fuelCount
        );
    }
    
    public void partTwo() {   
        int[] startingValues = generateValues(true);
        int needle = 0;
        for(int value : startingValues) {
            needle += value;
        }
        needle = (int) Math.floor((double) needle / startingValues.length);
        System.out.println(
            "2021 Day Seven - Part Two = Fuel needed : " + calculateScorePartTwo(startingValues, needle)
        );
    }
    
    private int[] generateValues(boolean p2) {
        String[] stringValues = getInput(fileLocation).get(0).split(",");
        int[] startingValues = new int[stringValues.length];
        for(int i = 0 ; i < stringValues.length ; i++) {
            if(p2) {
                startingValues[i] = Integer.parseInt(stringValues[i]) + 1;
            } else {
               startingValues[i] = Integer.parseInt(stringValues[i]);
            }
        }
        Arrays.sort(startingValues);
        return startingValues;
    }
    
    private int calculateScorePartTwo(int[] startingValues, int needle) {
        int fuelCount = 0;
        for(int value : startingValues) {
            int min = 0;
            int max = 0;
            if(value < needle) {
                min = value;
                max = needle;
            } else {
                min = needle;
                max = value;
            }
            int counter = 0;
            for(int i = min ; i < max ; i++) {
                counter++;
                fuelCount += counter;
            }
        }
        return fuelCount;
    }
}