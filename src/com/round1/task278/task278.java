package com.round1.task278;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task278 {

    private static String INPUT_FILENAME =  "src\\com\\round1\\task278\\input.txt";
    private static String OUTPUT_FILENAME =  "src\\com\\round1\\task278\\output.txt";
    private static String answer_Yes = "YES";
    private static String answer_NO = "NO";

    public static void main(String[] args) {
        BufferedReader readBuff;
        try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter(OUTPUT_FILENAME, false))) {
            readBuff = new BufferedReader(new FileReader(INPUT_FILENAME));
            String dNKSequence = readBuff.readLine();
            String evolutionDNKSequence = readBuff.readLine();
            checkFileLength();
            if (checkSequence(dNKSequence) && checkSequence(evolutionDNKSequence) && !dNKSequence.isEmpty()
                    && !evolutionDNKSequence.isEmpty() && checkFileLength()) {
                writeBuff.write(checkEvolution(dNKSequence, evolutionDNKSequence));
            } else writeBuff.write(answer_NO);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка");
        }

    }

    private static boolean checkFileLength(){
        File file = new File(INPUT_FILENAME);
        if(file.exists()) {
            double kilobytes = (double)file.length() / 1024;
            return kilobytes < 256;
        }
        return false;
    }

    private static String checkEvolution(String dNKSequence, String evolutionDNKSequence) {
        int startOfSubstring = 0;
        String checker = answer_Yes;
        if (dNKSequence.length() > evolutionDNKSequence.length()) {
            return answer_NO;
        }
        for (char latter : dNKSequence.toCharArray()) {
            if (startOfSubstring > evolutionDNKSequence.length()) {
                return answer_NO;
            }
            for (int i = startOfSubstring; i < evolutionDNKSequence.length(); i++) {
                if (latter == evolutionDNKSequence.charAt(i)) {
                    startOfSubstring = i + 1;
                    checker = answer_Yes;
                    break;
                }
                checker = answer_NO;
            }
            if (checker.equals(answer_NO)) return answer_NO;
        }
        return answer_Yes;
    }

    private static boolean checkSequence(String sequence){
        StringBuilder patternLine = new StringBuilder("^['A','G','T','C']+$");
        Pattern patterrn = Pattern.compile(patternLine.toString());
        Matcher match = patterrn.matcher(sequence);
        return match.matches();

    }

//    private static boolean checkEvolutionV2(String dNKSequence, String evolutionDNKSequence) {
//        StringBuilder patternLine = new StringBuilder("^(.+)?");
//        for (int i = 0 ; i<dNKSequence.length();i++){
//                patternLine.append(dNKSequence.charAt(i)).append("(.+)?");
//        }
//        patternLine.append("$");
//        Pattern patterrn = Pattern.compile(patternLine.toString());
//        Matcher match = patterrn.matcher(evolutionDNKSequence);
//        return match.matches();
//    }

}
