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
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
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
        int score = 0;
        for(String line : lines) {
            // Split start and end
            String[] parts = line.split(" -> ");
            String[] startCoords = parts[0].split(",");
            String[] endCoords = parts[1].split(",");
            // Filter out diagonals
            if(startCoords[0].equals(endCoords[0]) || startCoords[1].equals(endCoords[1])) {
                int x1 = Integer.parseInt(startCoords[0]);
                int y1 = Integer.parseInt(startCoords[1]);
                int x2 = Integer.parseInt(endCoords[0]);
                int y2 = Integer.parseInt(endCoords[1]);
                int startX = 0;
                int endX = 0;
                int startY = 0;
                int endY = 0;
                // Decide start / end based on which one is higher.
                if (x1 > x2) {
                    startX = x2;
                    endX = x1;
                } else {
                    startX = x1;
                    endX = x2;
                }
                if (y1 > y2) {
                    startY = y2;
                    endY = y1;
                } else {
                    startY = y1;
                    endY = y2;
                }
                // Draw lines
                for(int i = startX ; i <= endX ; i++) {
                    for (int j = startY ; j <= endY ; j++) {
                        map[i][j]++;
                    }
                }
            }
        }
        // Count result for answer
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] > 1) {
                    score++;
                }
            }
        }
        // Present the awnser.
        System.out.println(
            "2021 Day Five - Part One = Score : " + score
        );
    }
    /**
     * Second part of day five.
     */
    public void partTwo() {
        System.out.println(
            "2021 Day Five - Part Two = "
        );
    }
}
