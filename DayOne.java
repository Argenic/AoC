package AoC.year21;

import AoC.Day;
import java.util.*;

public class DayOne extends Day {
    
    public String fileLocation = "files/21/01/source.txt";
    //public String fileLocation = "files/21/01/sample.txt";
    
    public void partOne() {
        int previous = 0;
        int increases = 0;
        for(String line : getInput(fileLocation)) {
            int currentValue = Integer.parseInt(line);
            if(previous != 0) {
                if(currentValue > previous) {
                    increases++;
                }
            }
            previous = currentValue;
        }
        System.out.println(
            "2021 Day One - Part One = Total increases : " + increases
        );
    }
    
    public void partTwo() {
        ArrayList<String> lines = getInput(fileLocation);
        int previous = 0;
        int increases = 0;
        for(int i = 2 ; i < lines.size() ; i++) {
            int currentSize = 
                Integer.parseInt(lines.get(i-2)) +
                Integer.parseInt(lines.get(i-1)) +
                Integer.parseInt(lines.get(i));
           if(previous != 0) {
                if(currentSize > previous) {
                    increases++;
                }
            }
            previous = currentSize;
        }
        System.out.println(
            "2021 Day One - Part Two = Total increases : " + increases
        );
    }
}