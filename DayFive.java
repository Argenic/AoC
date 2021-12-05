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
public class DayFive {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day five.
     */
    public DayFive() {
        try {
            //File myObj = new File("files/21/05/sample.txt");
            File myObj = new File("files/21/05/source.txt");
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
     * First part of day five.
     */
    public void partOne() {
        // Setup some vars
        int[][] map = new int[1000][1000];
        for(String line : lines) {
            // Split start and end
            String[] parts = line.split(" -> ");
            String[] startString = parts[0].split(",");
            String[] endString = parts[1].split(",");
            int[] startCoords = new int[]{Integer.parseInt(startString[0]),Integer.parseInt(startString[1])};
            int[] endCoords = new int[]{Integer.parseInt(endString[0]), Integer.parseInt(endString[1])};
            map = drawStraightLine(map, startCoords, endCoords);            
        }
        // Present the awnser.
        System.out.println(
            "2021 Day Five - Part One = Score : " + countScore(map)
        );
    }
    
    /**
     * Second part of day five.
     */
    public void partTwo() {        
        // Setup some vars
        int[][] map = new int[1000][1000];
        for(String line : lines) {
            // Split start and end
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
    
    /**
     * Count the danger zones.
     * @param map
     * @return 
     */
    private int countScore(int[][] map) {
        int score = 0;
        // Count result for answer
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] > 1) {
                    score++;
                }
            }
        }
        return score;
    }
    
    /**
     * Draw lines on the map
     * @param map
     * @param start
     * @param end
     * @return 
     */
    private int[][] drawStraightLine(int[][] map, int[] start, int[] end) {
        // Filter out diagonals
        if(start[0] == end[0] || start[1] == end[1]) {
            // TODO learn some java8 syntax to clean this mess up
            int startX = 0;
            int endX = 0;
            int startY = 0;
            int endY = 0;
            // Decide start / end based on which one is higher.
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
            // Draw lines
            for(int i = startX ; i <= endX ; i++) {
                for (int j = startY ; j <= endY ; j++) {
                    map[i][j]++;
                }
            }
        }
        return map;
    }
    
    private int[][] drawDiagonalLine(int[][]map, int[] start, int[] end) {
        // Filter out straight lines
        if(start[0] != end[0] && start[1] != end[1]) {
            int[] begin = null;
            int[] finish = null;
            // Check x order to make it easer.
            if(start[0] > end[0]) {
                begin = end;
                finish = start;
            } else {
                begin = start;
                finish = end;
            }
            // Loop the x, deduce the corresponding y
            for(int i = begin[0] ; i <= finish[0] ; i++) {
                if(begin[1] <= finish[1]) {
                    // Higher the Y and mark the map
                    map[i][begin[1]++]++;
                } else {
                    // Lower our Y and mark the map
                    map[i][begin[1]--]++;
                }
            }
        }
        return map;
    }
}
