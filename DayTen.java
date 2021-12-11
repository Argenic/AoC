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
    
    private LinkedList<String> lines = new LinkedList<>();
    private List marked = new ArrayList<String>();
    
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
            e.printStackTrace();
        }
    }
    
    /**
     * First part of day ten.
     */
    public void partOne() {
        int count = 0;
        List openingChars = new ArrayList<Character>(Arrays.asList('<', '(', '[', '{'));
        LinkedList<Character> openingSequence = new LinkedList<>();
        for(String line : lines) {
            char lastOpening = line.charAt(0);
            for(int i = 1 ; i < line.length() ; i++) {
                char currentChar = line.charAt(i);
                if(openingChars.contains(currentChar)) {
                    openingSequence.push(lastOpening);
                    lastOpening = currentChar;
                } else {
                    boolean stopSignal = false;
                    switch (currentChar) {
                        case '>' :
                            if (lastOpening != '<') {
                                stopSignal = true;
                            } else {
                                lastOpening = openingSequence.pop();
                            }
                            break;
                        case ')' :
                            if (lastOpening != '(') {
                                stopSignal = true;
                            } else {
                                lastOpening = openingSequence.pop();
                            }
                            break;
                        case ']' :
                            if (lastOpening != '[') {
                                stopSignal = true;
                            } else {
                                lastOpening = openingSequence.pop();
                            }
                            break;
                        case '}' :
                            if (lastOpening != '{') {
                                stopSignal = true;
                            } else {
                                lastOpening = openingSequence.pop();
                            }
                            break;
                        default:
                            break;
                    }
                    if(stopSignal) {
                        count += getScore(currentChar);
                        break;
                    }
                }
            }
        }        
        System.out.println(
            "2021 Day Ten - Part One = Syntax Error Score : " + count
        );
    }
    
    /**
     * Second part of day ten.
     */
    public void partTwo() {
        System.out.println(
            "2021 Day Ten - Part Two = "
        );
    }
    
    private int getScore(char input) {
        int score = 0;
        switch (input) {
            case ')' :
                score = 3;
                break;
            case ']' :
                score = 57;
                break;
            case '}' :
                score = 1197;
                break;
            case '>' :
                score = 25137;
                break;
        }
        return score;
    }
}
