package com.round1.task278;

import java.io.*;
import java.util.ArrayList;

public class task278 {
    public static void main(String[] args) {
        BufferedReader readBuff;
        File inputfile = new File("src\\com\\round1\\task278\\input.txt");
        try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task278\\output.txt", false))) {
            if (inputfile.exists()) try {
                if ((inputfile.lastModified() / 1024) >= 256) {
                    readBuff = new BufferedReader(new FileReader("src\\com\\round1\\task278\\input.txt"));
                    String dNKSequence = readBuff.readLine();
                    String evolutionDNKSequence = readBuff.readLine();
                    writeBuff.write(String.valueOf(CheckEvolution(dNKSequence, evolutionDNKSequence)));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean CheckEvolution(String dNKSequence, String evolutionDNKSequence) {
        ArrayList<String> buffArray = new ArrayList<>();
        Integer startOfSubstring = 0;
        for (int j = 0; j < dNKSequence.length(); j++) {
            for (int i = startOfSubstring; i < evolutionDNKSequence.length(); i++) {
                if (dNKSequence.charAt(j) == evolutionDNKSequence.charAt(i)) {
                    buffArray.add(evolutionDNKSequence.substring(startOfSubstring, i + 1));
                    startOfSubstring = i;
                    break;
                }
            }
        }
        return buffArray.size() == dNKSequence.length();
    }
}
