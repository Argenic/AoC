package AoC.year21;

import AoC.Day;
import java.util.*;

public class DayTen extends Day {
    
    public String fileLocation = "files/21/10/source.txt";
    //public String fileLocation = "files/21/10/sample.txt";
    
    private int syntaxErrorScore = 0;
    private ArrayList<Long> autoCompleteScores = new ArrayList<>();
    private List openingChars = new ArrayList<Character>(Arrays.asList('<', '(', '[', '{'));
    
    public void partOne() {
        filterSyntaxErrors(getInput(fileLocation));
        System.out.println(
                "2021 Day Ten - Part One = Syntax Error Score : " + syntaxErrorScore
        );
    }
    
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