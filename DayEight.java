package AoC.year21;

import AoC.Day;
import java.util.*;

public class DayEight extends Day {

    public String fileLocation = "files/21/08/source.txt";
    //public String fileLocation = "files/21/08/sample.txt";
    
    public void partOne() {
        int count = 0;
        for(String line : getInput(fileLocation)) {
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
    
    public void partTwo() {   
        int count = 0;
        for(String line : getInput(fileLocation)) {
            String[] values = line.split(" \\| ");
            String[] knownValues = new String[10];
            String[] fiveDigits = new String[3];
            String[] sixDigits = new String[3];
            int fiveCount = 0;
            int sixCount = 0;
            char topRight = ' ';
            char bottomLeft = ' ';
            String finalValue = "";
            for(String pattern : values[0].split(" ")) {
                switch (pattern.length()) {
                    case 2 -> // Filter : 1
                        knownValues[1] = sortDigitString(pattern);
                    case 4 -> // Filter : 4
                        knownValues[4] = sortDigitString(pattern);
                    case 3 -> // Filter : 7
                        knownValues[7] = sortDigitString(pattern);
                    case 7 -> // Filter : 8
                        knownValues[8] = sortDigitString(pattern);
                    case 5 -> // Filter : 2, 3, 5
                        fiveDigits[fiveCount++] = sortDigitString(pattern);
                    case 6 -> // Filter : 0, 6, 9
                        sixDigits[sixCount++] = sortDigitString(pattern);
                }
            }
            // Get 6 with the help of 1, create a needle from it,         
            for(String digit : sixDigits) {
                if(!digit.contains(Character.toString(knownValues[1].charAt(0)))) {
                    topRight = knownValues[1].charAt(0);
                    knownValues[6] = digit;
                }
                if(!digit.contains(Character.toString(knownValues[1].charAt(1)))) {
                    topRight = knownValues[1].charAt(1);
                    knownValues[6] = digit;
                }
            }
            // Get the 5 digits, create another needle,
            for(String digit : fiveDigits) {
                // Filter out the values based on one and our first needle
                if(digit.contains(Character.toString(knownValues[1].charAt(0))) && digit.contains(Character.toString(knownValues[1].charAt(1)))) {
                    // 3
                    knownValues[3] = digit;
                } else if(digit.contains(Character.toString(topRight))) {
                    // 2
                    knownValues[2] = digit;
                } else {
                    // 5
                    knownValues[5] = digit;
                    for(int i = 0 ; i < knownValues[8].length() ; i++) {
                        if(
                            !digit.contains(Character.toString(knownValues[8].charAt(i))) &&
                            !(topRight == knownValues[8].charAt(i))
                        ) {
                            bottomLeft = knownValues[8].charAt(i);
                            break;
                        }
                    }
                }
            }
            // Finally filter out 0, 9 with our needles       
            for(String digit : sixDigits) {
                if(
                    digit.contains(Character.toString(bottomLeft)) && 
                    digit.contains(Character.toString(topRight))
                ) {
                    // 0
                    knownValues[0] = digit;
                } else if (!digit.contains(Character.toString(bottomLeft))) {
                    // 9
                    knownValues[9] = digit;
                }
            }
            // loop the output numbers
            for(String number : values[1].split(" ")) {
                number = sortDigitString(number);
                for(int i = 0 ; i < knownValues.length ; i++) {
                    if(number.equals(knownValues[i])) {
                        finalValue += "" + Integer.toString(i);
                    }
                }                
            }
            count += Integer.parseInt(finalValue);
        }
        System.out.println(
            "2021 Day Eight - Part Two = Total output " + count
        );
    }
    
    private String sortDigitString(String digit) {
        char[] charArray = digit.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}