package com.round1.task278;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task278 {

    private static String INPUTFILENAME =  "src\\com\\round1\\task278\\input.txt";
    private static String OUTPUTFILENAME =  "src\\com\\round1\\task278\\output.txt";

    public static void main(String[] args) {
        BufferedReader readBuff;
        try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter(OUTPUTFILENAME, false))) {
            readBuff = new BufferedReader(new FileReader(INPUTFILENAME));
            String dNKSequence = readBuff.readLine();
            String evolutionDNKSequence = readBuff.readLine();
            checkFileLength();
            if (checkSequence(dNKSequence) && checkSequence(evolutionDNKSequence) && !dNKSequence.isEmpty()
                    && !evolutionDNKSequence.isEmpty() && checkFileLength()) {
                writeBuff.write(checkEvolution(dNKSequence, evolutionDNKSequence));
            } else writeBuff.write("NO");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка");
        }

    }

    private static boolean checkFileLength(){
        File file = new File(INPUTFILENAME);
        if(file.exists()) {
            double kilobytes = (double)file.length() / 1024;
            return kilobytes < 256;
        }
        return false;
    }

    private static String checkEvolution(String dNKSequence, String evolutionDNKSequence) {
        int startOfSubstring = 0;
        String answer ="NO";
        if (dNKSequence.length()<=evolutionDNKSequence.length()) {
            for (char latter : dNKSequence.toCharArray()) {
                if (startOfSubstring < evolutionDNKSequence.length()) {
                    for (int i = startOfSubstring; i < evolutionDNKSequence.length(); i++) {
                        if (latter == evolutionDNKSequence.charAt(i)) {
                            startOfSubstring = i + 1;
                            answer = "YES";
                            break;
                        }
                        answer="NO";
                    }
                }
                    else{
                        answer = "NO";
                        break;
                    }
                if (answer.equals("NO")) break;
            }
        }
        return answer;
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
