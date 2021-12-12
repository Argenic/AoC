package AoC.year21;

import AoC.Day;
import java.util.ArrayList;

public class DayEleven extends Day {

    public String fileLocation = "files/21/11/source.txt";
    //public String fileLocation = "files/21/11/sample.txt";
    private Blinker[][] map;
    private int blinks = 0;
    
    public void partOne() {
        buildMap();
        //printMap();
        for(int i = 0 ; i < 100 ; i++) {
            step();
            //System.out.println("-----STEP# " + i + "-----");
            //printMap();
        }
        System.out.println(
                "2021 Day Eleven - Part One = Amount of Blinks : " + blinks
        );
    }
    
    public void partTwo() {
        buildMap();
        boolean singularity = false;
        int steps = 0;
        while(!singularity) {
            step();
            steps++;
            singularity = checkSingularity(); 
        }
        System.out.println(
            "2021 Day Eleven - Part Two = Singularity after : " + steps 
        );
    }
    
    private void buildMap() {
        ArrayList<String> lines = getInput(fileLocation);
        map = new Blinker[lines.size()][lines.get(0).length()];
        for(int i = 0 ; i < lines.size() ; i++) {
            for(int j = 0 ; j < lines.get(i).length() ; j++) {
                int value = Character.getNumericValue(lines.get(i).charAt(j));
                map[i][j] = new Blinker(value, i, j);
            }
        }
    }
    
    private boolean checkSingularity() {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j].getValue() != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void printMap() {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                System.out.print(map[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
    
    private ArrayList<Blinker> blink(Blinker node) {
        ArrayList<Blinker> triggered = new ArrayList<>();
        blinks++;
        for(int i = node.getX() - 1 ; i <= node.getX() + 1 ; i++) {
            for(int j = node.getY() - 1 ; j <= node.getY() + 1 ; j++) {
                if(
                    i < 0 ||
                    i >= map.length ||
                    j < 0 ||
                    j >= map[i].length
                ) {
                    continue;
                }
                if(map[i][j].increment()) {
                    triggered.add(map[i][j]);
                }
            }
        }
        return triggered;
    }
    
    private void step() {
        ArrayList<Blinker> triggered = incrementAll();
        while(!triggered.isEmpty()) {
            Blinker current = triggered.get(0);
            ArrayList<Blinker> more = blink(current);
            triggered.remove(current);
            triggered.addAll(more);
        }
    }
    
    private ArrayList<Blinker> incrementAll() {
        ArrayList<Blinker> triggered = new ArrayList<>();
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                map[i][j].newStep();
                if(map[i][j].increment()) {
                    triggered.add(map[i][j]);
                }
            }
        }
        return triggered;
    }
}