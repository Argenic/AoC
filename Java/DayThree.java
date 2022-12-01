package AoC.year21;

import AoC.Day;
import java.util.ArrayList;

public class DayThree extends Day {

    public String fileLocation = "files/21/03/source.txt";
    //public String fileLocation = "files/21/03/sample.txt";
    
    public void partOne() {
        ArrayList<String> lines = getInput(fileLocation);
        int[] ones = new int[lines.get(0).length()];
        String gammaBinaryString = "";
        String epsilonBinaryString = "";
        for(String line : lines) {
            for(int i = 0 ; i < line.length() ; i++) {
                if(line.charAt(i) == '1') {
                    ones[i]++;
                }
            }
        }
        for(int i = 0 ; i < ones.length ; i++) {
            if(ones[i] > lines.size() / 2 ) {
                gammaBinaryString += "1";
                epsilonBinaryString += "0";
            } else if (ones[i] < lines.size() / 2 ){
                gammaBinaryString += "0";
                epsilonBinaryString += "1";
            } else {
                System.out.println("AH OH!!??");
            }
        }
        int gamma = Integer.parseInt(gammaBinaryString, 2);
        int epsilon = Integer.parseInt(epsilonBinaryString, 2);
        System.out.println(
            "2021 Day Three - Part One = Gamma:" + gamma + 
            " * Epsilon:" + epsilon +
            " = " + gamma * epsilon
        );
    }

    public void partTwo() {
        ArrayList<String> lines = getInput(fileLocation);
        ArrayList<String> generatorList = (ArrayList) lines.clone();
        ArrayList<String> scrubberList = (ArrayList) lines.clone();
        for(int i = 0 ; i < lines.get(0).length() ; i++) {
            ArrayList<String> zeroes = new ArrayList();
            ArrayList<String> ones = new ArrayList();
            for(String generatorLine : generatorList) {
                if(generatorLine.charAt(i) == '0') {
                    zeroes.add(generatorLine);
                } else if (generatorLine.charAt(i) == '1') { 
                    ones.add(generatorLine);
                }
            }
            if(ones.size() >= zeroes.size()) {
                generatorList = ones;
            } else {
                generatorList = zeroes;
            }
            if(scrubberList.size() == 1) {
                continue;
            }
            zeroes = new ArrayList();
            ones = new ArrayList();
            for(String scrubberLine : scrubberList) {
                if(scrubberLine.charAt(i) == '0') {
                    zeroes.add(scrubberLine);
                } else if (scrubberLine.charAt(i) == '1') { 
                    ones.add(scrubberLine);
                }
            }
            if(zeroes.size() > ones.size()) {
                scrubberList = ones;
            } else {
                scrubberList = zeroes;
            }
        }
        int generator = Integer.parseInt(generatorList.get(0), 2);
        int scrubber = Integer.parseInt(scrubberList.get(0), 2);
        System.out.println(
            "2021 Day Three - Part Two = Generator:" + generator + 
            " * Scrubber:" + scrubber +
            " = " + generator * scrubber
        );
    }
}
