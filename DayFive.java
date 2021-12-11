package AoC.year21;

import AoC.Day;

public class DayFive extends Day {
 
    public String fileLocation = "files/21/05/source.txt";
    //public String fileLocation = "files/21/05/sample.txt";
       
    public void partOne() {
        int[][] map = new int[1000][1000];
        for(String line : getInput(fileLocation)) {
            String[] parts = line.split(" -> ");
            String[] startString = parts[0].split(",");
            String[] endString = parts[1].split(",");
            int[] startCoords = new int[]{Integer.parseInt(startString[0]),Integer.parseInt(startString[1])};
            int[] endCoords = new int[]{Integer.parseInt(endString[0]), Integer.parseInt(endString[1])};
            map = drawStraightLine(map, startCoords, endCoords);            
        }
        System.out.println(
            "2021 Day Five - Part One = Score : " + countScore(map)
        );
    }
    
    public void partTwo() {        
        int[][] map = new int[1000][1000];
        for(String line : getInput(fileLocation)) {
            String[] parts = line.split(" -> ");
            String[] startString = parts[0].split(",");
            String[] endString = parts[1].split(",");
            int[] startCoords = new int[]{Integer.parseInt(startString[0]),Integer.parseInt(startString[1])};
            int[] endCoords = new int[]{Integer.parseInt(endString[0]), Integer.parseInt(endString[1])};
            map = drawStraightLine(map, startCoords, endCoords);            
            map = drawDiagonalLine(map, startCoords, endCoords);
        }
        System.out.println(
            "2021 Day Five - Part Two = Score : " + countScore(map)
        );
    }
    
    private int countScore(int[][] map) {
        int score = 0;
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] > 1) {
                    score++;
                }
            }
        }
        return score;
    }
    
    private int[][] drawStraightLine(int[][] map, int[] start, int[] end) {
        if(start[0] == end[0] || start[1] == end[1]) {
            int startX = 0;
            int endX = 0;
            int startY = 0;
            int endY = 0;
            if (start[0] > end[0]) {
                startX = end[0];
                endX = start[0];
            } else {
                startX = start[0];
                endX = end[0];
            }
            if (start[1] > end[1]) {
                startY = end[1];
                endY = start[1];
            } else {
                startY = start[1];
                endY = end[1];
            }
            for(int i = startX ; i <= endX ; i++) {
                for (int j = startY ; j <= endY ; j++) {
                    map[i][j]++;
                }
            }
        }
        return map;
    }
    
    private int[][] drawDiagonalLine(int[][]map, int[] start, int[] end) {
        if(start[0] != end[0] && start[1] != end[1]) {
            int[] begin = null;
            int[] finish = null;
            if(start[0] > end[0]) {
                begin = end;
                finish = start;
            } else {
                begin = start;
                finish = end;
            }
            for(int i = begin[0] ; i <= finish[0] ; i++) {
                if(begin[1] <= finish[1]) {
                    map[i][begin[1]++]++;
                } else {
                    map[i][begin[1]--]++;
                }
            }
        }
        return map;
    }
}