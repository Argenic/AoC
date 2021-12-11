/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AoC.year21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author simon
 */
public class DayTen {
    
    private ArrayList<String> lines = new ArrayList<>();
    private int syntaxErrorScore = 0;
    private ArrayList<Long> autoCompleteScores = new ArrayList<>();
    private List openingChars = new ArrayList<Character>(Arrays.asList('<', '(', '[', '{'));
    
    /**
     * Setup day ten.
     */
    public DayTen() {
        try {
            //File myObj = new File("files/21/10/sample.txt");
            File myObj = new File("files/21/10/source.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
    
    /**
     * First part of day ten.
     */
    public void partOne() {
        filterSyntaxErrors(lines);
        System.out.println(
                "2021 Day Ten - Part One = Syntax Error Score : " + syntaxErrorScore
        );
    }
    
    /**
     * Second part of day ten.
     */
    public void partTwo() {
        Collections.sort(autoCompleteScores);
        long median = autoCompleteScores.get(autoCompleteScores.size() / 2);
        System.out.println(
            "2021 Day Ten - Part Two = Auto complete score : " + median
        );
    }
    
    private ArrayList<String> filterSyntaxErrors (ArrayList<String> errors) {
        ArrayList<String> validErrors = new ArrayList<>();
        for(String error : errors) {
            LinkedList<Character> openingSequence = new LinkedList<>();
            char lastOpening = error.charAt(0);
            boolean stopSignal = false;
            boolean skipBool = true;
            for(int i = 1 ; i < error.length() ; i++) {
                char currentChar = error.charAt(i);
                if(openingChars.contains(currentChar)) {
                    if(openingSequence.isEmpty() && i > 1 && skipBool) {
                        skipBool = false;
                    } else {
                        openingSequence.push(lastOpening);
                        skipBool = true;
                    }
                    lastOpening = currentChar;
                } else {
                    switch (currentChar) {
                        case '>' -> {
                            if (lastOpening != '<') {
                                stopSignal = true;
                            }
                        }
                        case ')' -> {
                            if (lastOpening != '(') {
                                stopSignal = true;
                            }
                        }
                        case ']' -> {
                            if (lastOpening != '[') {
                                stopSignal = true;
                            }
                        }
                        case '}' -> {
                            if (lastOpening != '{') {
                                stopSignal = true;
                            }
                        }
                        default -> {
                        }
                    }
                    if(stopSignal) {
                        syntaxErrorScore += getScore(currentChar);
                        break;
                    } else {
                        if (openingSequence.size() > 0) {
                            lastOpening = openingSequence.pop();
                        }
                    }
                }
            }
            if(!stopSignal) {
                openingSequence.push(lastOpening);
                autoCompleteErrors(openingSequence);
                validErrors.add(error);
            }
        }
        return validErrors;
    }
    
    private void autoCompleteErrors(LinkedList<Character> openingSequence) {
        long score = 0;
        while(!openingSequence.isEmpty()) {
            char lastOpening = openingSequence.pop();
            score *= 5;
            switch (lastOpening) {
                case '(' -> score += 1;
                case '[' -> score += 2;
                case '{' -> score += 3;
                case '<' -> score += 4;
            }            
        }
        autoCompleteScores.add(score);
    }
    
    private int getScore(char input) {
        int score = 0;
        switch (input) {
            case ')' -> score = 3;
            case ']' -> score = 57;
            case '}' -> score = 1197;
            case '>' -> score = 25137;
        }
        return score;
    }
}
