package AoC.year21;

import AoC.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class DayFour extends Day {
    
    public String fileLocation = "files/21/04/source.txt";
    //public String fileLocation = "files/21/04/sample.txt";
    
    public void partOne() {
        String[] numberStream = getInput(fileLocation).get(0).split(",");
        List<Integer> drawnNumbers = new ArrayList<Integer>();
        LinkedList<int[][]> boards = buildBoards();
        int[][] winner = null;
        for(int i = 0 ; i < numberStream.length ; i++) {
            drawnNumbers.add(Integer.parseInt(numberStream[i]));
            if(i > 4) {
                for(int[][] board : boards) {
                    if(checkBoard(board, drawnNumbers)) {
                        winner = board;
                        break;
                    }
                }
            }
            if(winner != null) {
                break;
            }
        }
        int score = calculateScore(winner, drawnNumbers);
        int lastNumber = drawnNumbers.get(drawnNumbers.size() - 1);
        System.out.println(
            "2021 Day Four - Part One = Number:" + lastNumber +
            " * Score:" + score + " = " + lastNumber * score
        );
    }
    
    public void partTwo() {
        String[] numberStream = getInput(fileLocation).get(0).split(",");
        List<Integer> drawnNumbers = new ArrayList<Integer>();
        LinkedList<int[][]> boards = buildBoards();
        int[][] loser = null;
        for(int i = 0 ; i < numberStream.length ; i++) {
            drawnNumbers.add(Integer.parseInt(numberStream[i]));
            if(i > 4) {                
                for(Iterator<int[][]> iterator = boards.iterator() ; iterator.hasNext();) {
                    int[][] board = iterator.next();
                    if(checkBoard(board, drawnNumbers)) {
                        iterator.remove();
                    }
                    if(boards.isEmpty()) {
                        loser = board;
                        break;
                    }
                }
            }
            if(loser != null) {
                break;
            }
        }
        int score = calculateScore(loser, drawnNumbers);
        int lastNumber = drawnNumbers.get(drawnNumbers.size() - 1);
        System.out.println(
            "2021 Day Four - Part Two = Number:" + lastNumber +
            " * Score:" + score + " = " + lastNumber * score
        );
    }
    
    private LinkedList<int[][]> buildBoards() {
        LinkedList<int[][]> boards = new LinkedList<>();
        ArrayList<String> lines = getInput(fileLocation);
        for(int i = 2 ; i < lines.size() ; i += 6) {
            int[][] board = new int[5][5];
            for(int j = 0 ; j < board.length ; j++) {
                String[] values = lines.get(i + j).trim().split("\\s+");
                for(int k = 0 ; k < values.length ; k++) {
                    board[j][k] = Integer.parseInt(values[k]);
                }
            }
            boards.add(board);
        }
        return boards;
    }

    private boolean checkBoard(int[][] board, List drawnNumbers) {
        for(int x = 0 ; x < board.length ; x++) {
            int horizontalBingoCount = 0;
            int verticalBingoCount = 0;
            for (int y = 0  ; y < board[x].length ; y++) {
                if(drawnNumbers.contains(board[x][y])) {
                    horizontalBingoCount++;
                }
                if(drawnNumbers.contains(board[y][x])) {
                    verticalBingoCount++;
                }
            }
            if(horizontalBingoCount == 5 || verticalBingoCount == 5) {
                return true;
            }
        }
        return false;
    }
    
    private int calculateScore(int[][] board, List drawnNumbers) {
        int score = 0;
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(!drawnNumbers.contains(board[i][j])) {
                    score += board[i][j];
                }
            }
        }
        return score;
    }
}