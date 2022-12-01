package AoC.year21;

import AoC.Day;

public class DaySix extends Day {
    
    public String fileLocation = "files/21/06/source.txt";
    //public String fileLocation = "files/21/06/sample.txt";
    
    public void partOne() {
        System.out.println(
            "2021 Day Six - Part One = Amount of fishes : " + birdsOnDay(80)
        );
    }
    
    public void partTwo() {   
        System.out.println(
            "2021 Day Six - Part Two = Amount of fishes : " + birdsOnDay(256)
        );
    }
    
    private long birdsOnDay(int days) {
        String line = getInput(fileLocation).get(0);
        String[] instructions = line.split(",");
        long[] birdsPerDay = new long[9];
        for(int i = 0 ; i < instructions.length ; i++) {
            int instruction = Integer.parseInt(instructions[i]);
            birdsPerDay[instruction]++;
        }
        for(int i = 0 ; i < days ; i++){
            long[] newBirdsPerDay = new long[9];
            for(int j = 1 ; j < birdsPerDay.length ; j++) {
                newBirdsPerDay[j - 1] = birdsPerDay[j];
            }
            newBirdsPerDay[8] = birdsPerDay[0];
            newBirdsPerDay[6] += birdsPerDay[0];
            birdsPerDay = newBirdsPerDay;
        }
        long count = 0;
        for(int j = 0 ; j < birdsPerDay.length ; j++) {
            count += birdsPerDay[j];
        }
        return count;
    }
}