package com.round1.task278;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task278 {
    public static void main(String[] args) {
        BufferedReader readBuff;
        try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task278\\output.txt", false))) {
            readBuff = new BufferedReader(new FileReader("src\\com\\round1\\task278\\input.txt"));
            String dNKSequence = readBuff.readLine();
            String evolutionDNKSequence = readBuff.readLine();
            if (checkEvolutionV2(dNKSequence, evolutionDNKSequence)) {
                writeBuff.write("YES");
            } else {
                writeBuff.write("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private static boolean checkEvolution(String dNKSequence, String evolutionDNKSequence) {
//        int evolutionCount = 0;
//        Integer startOfSubstring = 0;
//        for (int j = 0; j < dNKSequence.length(); j++) {
//            for (int i = startOfSubstring; i < evolutionDNKSequence.length(); i++) {
//                if (dNKSequence.charAt(j) == evolutionDNKSequence.charAt(i)) {
//                    evolutionCount++;
//                    startOfSubstring = i;
//                    break;
//                }
//            }
//        }
//        return evolutionCount == dNKSequence.length();
//    }

    private static boolean checkEvolutionV2(String dNKSequence, String evolutionDNKSequence) {
        StringBuilder patternLine = new StringBuilder("^(.+)?");
        for (int i = 0 ; i<dNKSequence.length();i++){
                patternLine.append(dNKSequence.charAt(i)).append("(.+)?");
        }
        patternLine.append("$");
        Pattern patterrn = Pattern.compile(patternLine.toString());
        Matcher match = patterrn.matcher(evolutionDNKSequence);
        return match.matches();
    }
}
