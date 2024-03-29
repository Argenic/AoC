package AoC.year21;

import AoC.Day;
import java.util.*;

public class DayNine extends Day {

    public String fileLocation = "files/21/09/source.txt";
    //public String fileLocation = "files/21/09/sample.txt";
    
    private List marked = new ArrayList<String>();
    
    public void partOne() {
        int[][] heightMap = buildMap();
        List<int[]> lowPoints = getLowPoints(heightMap);
        int count = 0;
        for(int[] point : lowPoints) {
            count += heightMap[point[0]][point[1]] + 1;
        } 
       System.out.println(
            "2021 Day Nine - Part One = Dips : " + count
        );
    }
    
    public void partTwo() {
        int[][] heightMap = buildMap();
        List<int[]> lowPoints = getLowPoints(heightMap);
        List areas = new ArrayList<Integer>();
        for(int[] point : lowPoints) {
            buildArea(point, heightMap);
            areas.add(marked.size());
            marked = new ArrayList<String>();
        }
        Collections.sort(areas, Collections.reverseOrder());
        int areaCount = (Integer) areas.get(0);
        areaCount *= (Integer) areas.get(1);
        areaCount *= (Integer) areas.get(2);
        System.out.println(
            "2021 Day Nine - Part Two = Area " + areaCount
        );
    }
    
    private int[][] buildMap() {
        ArrayList<String> lines = getInput(fileLocation);
        int[][] heightMap = new int[lines.size()][lines.get(0).length()];
        for(int i = 0 ; i < lines.size() ; i++) {
            String line = lines.get(i);
            for(int j = 0 ; j < line.length() ; j++) {
                heightMap[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        return heightMap;
    }
    
    private List getLowPoints(int[][] heightMap) {
        List lowPoints = new ArrayList<int[]>();
        for(int i = 0 ; i < heightMap.length ; i++) {
            for(int j = 0 ; j < heightMap[i].length ; j++) {
                int currentValue = heightMap[i][j];
                if(
                    (i == 0 || currentValue < heightMap[i-1][j]) &&                     // TOP
                    (i == heightMap.length - 1 || currentValue < heightMap[i+1][j]) &&  // BOTTOM
                    (j == 0 || currentValue < heightMap[i][j-1]) &&                     // LEFT
                    (j == heightMap[i].length - 1 || currentValue < heightMap[i][j+1])  // RIGHT
                ) {
                    lowPoints.add(new int[]{i,j});
                }
            }
        }
        return lowPoints;
    }
    
    private void buildArea(int[] point, int[][] heightMap) {
        String pointValue = point[0] + "x" + point[1];
        if(!marked.contains(pointValue) && heightMap[point[0]][point[1]] < 9) {
            marked.add(pointValue);
            // Top
            if(point[0] > 0 && !marked.contains((point[0] - 1) + "x" + point[1])) {
                buildArea(new int[]{point[0] - 1, point[1]}, heightMap);
            }
            // Bottom
            if(point[0] < heightMap.length - 1 && !marked.contains((point[0] + 1) + "x" + point[1])) {
                buildArea(new int[]{point[0] + 1, point[1]}, heightMap);
            }
            // Left
            if(point[1] > 0 && !marked.contains(point[0] + "x" + (point[1] - 1))) {
                buildArea(new int[]{point[0], point[1] - 1}, heightMap);
            }
            // Right
            if(point[1] < heightMap[point[0]].length - 1 && !marked.contains(point[0] + "x" + point[1] + 1)) {
                buildArea(new int[]{point[0], point[1] + 1}, heightMap);                
            }
        }
    }
}