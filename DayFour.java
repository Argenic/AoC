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
/**
 *
 * @author simon
 */
public class DayFour {
    
    private LinkedList<String> lines = new LinkedList<>();
    
    /**
     * Setup day four.
     */
    public DayFour() {
        try {
            //File myObj = new File("files/21/04/sample.txt");
            File myObj = new File("files/21/04/source.txt");
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
     * First part of day four.
     */
    public void partOne() {
        // Setup some vars
        String[] numberStream = lines.get(0).split(",");
        List<Integer> drawnNumbers = new ArrayList<Integer>();
        LinkedList<int[][]> boards = buildBoards();
        int[][] winner = null;
        // Play the game
        for(int i = 0 ; i < numberStream.length ; i++) {
            drawnNumbers.add(Integer.parseInt(numberStream[i]));
            //System.out.println("NUMBERRR #" + i + " = " + drawnNumbers.get(i));
            // First for numbers will never make bingo anyway
            if(i > 4) {
                // Loop the boards to check for bingo
                for(int[][] board : boards) {
                    if(winner != null) {
                        break;
                    }
                    // Scan rows / columns
                    for(int x = 0 ; x < board.length ; x++) {
                        int horizontalBingoCount = 0;
                        int verticalBingoCount = 0;
                        for (int y = 0  ; y < board[x].length ; y++) {
                            // Check row
                            if(drawnNumbers.contains(board[x][y])) {
                                horizontalBingoCount++;
                            }
                            // Check column
                            if(drawnNumbers.contains(board[y][x])) {
                                verticalBingoCount++;
                            }
                        }
                        if(horizontalBingoCount == 5 || verticalBingoCount == 5) {
                            //System.out.println("BINGOOOOO");
                            winner = board;
                            break;
                        }
                    }
                }
            }
            if(winner != null) {
                break;
            }
        }
        // Score calculation
        int score = 0;
        int lastNumber = drawnNumbers.get(drawnNumbers.size() - 1);
        for(int i = 0 ; i < winner.length ; i++) {
            for(int j = 0 ; j < winner[i].length ; j++) {
                if(!drawnNumbers.contains(winner[i][j])) {
                    score += winner[i][j];
                }
            }
        }
        // Present the awnser.
        System.out.println(
            "2021 Day Four - Part One = Number:" + lastNumber +
            " * Score:" + score + " = " + lastNumber * score
        );
    }
    
    /**
     * Second part of day four.
     */
    public void partTwo() {
        System.out.println(
            "2021 Day Four - Part Two = "
        );
    }
    
    private LinkedList<int[][]> buildBoards() {
        LinkedList<int[][]> boards = new LinkedList<>();
        // Build the boards
        for(int i = 2 ; i < lines.size() ; i += 6) {
            int[][] board = new int[5][5];
            // Loop the rows
            for(int j = 0 ; j < board.length ; j++) {
                String[] values = lines.get(i + j).trim().split("\\s+");
                // Loop the values
                for(int k = 0 ; k < values.length ; k++) {
                    board[j][k] = Integer.parseInt(values[k]);
                }
            }
            boards.add(board);
        }
        return boards;
    }
}
