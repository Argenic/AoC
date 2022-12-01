package AoC.year21;

import AoC.Day;

public class DayTwo extends Day {

    public String fileLocation = "files/21/02/source.txt";
    //public String fileLocation = "files/21/02/sample.txt";
    
    public void partOne() {
        int depth = 0;
        int position = 0;
        for(String line : getInput(fileLocation)) {
            String[] instruction = line.split(" ");
            String operator = instruction[0];
            int value = Integer.parseInt(instruction[1]);
            switch(instruction[0]) {
                case "forward" -> position += value;
                case "up" -> depth -= value;
                case "down" -> depth += value;
                default -> System.out.println("Something went wrong : " + instruction[0]);
            }
        }
        int result = depth * position;
        System.out.println(
            "2021 Day Two - Part One = Depth:" + depth + 
            " * Position:" + position +
            " = " + result
        );
    }
    
    public void partTwo() {
        int depth = 0;
        int position = 0;
        int aim = 0;
        for(String line : getInput(fileLocation)) {
            String[] instruction = line.split(" ");
            String operator = instruction[0];
            int value = Integer.parseInt(instruction[1]);
            switch(instruction[0]) {
                case "forward" -> {
                    position += value;
                    depth += aim * value;
                }
                case "up" -> aim -= value;
                case "down" -> aim += value;
                default -> System.out.println("Something went wrong : " + instruction[0]);
            }
        }
        int result = depth * position;
        System.out.println(
            "2021 Day Two - Part Two = Depth:" + depth + 
            " * Position:" + position +
            " = " + result
        );
    }
}
