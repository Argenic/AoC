/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author simon
 */
public class DayNine {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day nine.
     */
    public DayNine() {
        try {
            //File myObj = new File("files/21/09/sample.txt");
            File myObj = new File("files/21/09/source.txt");
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
     * First part of day nine.
     */
    public void partOne() {
        // Setup some vars
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
    
    /**
     * Second part of day nine.
     */
    public void partTwo() {
        // Setup some vars
        int[][] heightMap = buildMap();
        List<int[]> lowPoints = getLowPoints(heightMap);
        for(int[] point : lowPoints) {
            
        }
        System.out.println(
            "2021 Day Nine - Part Two = "
        );
    }
    
    private int[][] buildMap() {
        int[][] heightMap = new int[lines.size()][lines.getFirst().length()];
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
}
