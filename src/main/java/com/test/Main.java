package com.test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String TARTGET_STRING = "aeiouAEIOU";

    private static final int DIVIDE_NUM = 2;

    private static final int ADD_NUM = 1;

    private static final ArrayList<Integer> sIndexList = new ArrayList<>();

    private static final ArrayList<Integer> sNumberList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int flaw = Integer.parseInt(cin.nextLine());
        String input = cin.nextLine();
        cin.close();

        System.out.println(getLongestFlawedVowelSubstrLen(flaw, input));
    }

    private static int getLongestFlawedVowelSubstrLen(int flaw, String input) {
        ArrayList<Character> vowelList = new ArrayList<>();
        for (int index = 0; index < TARTGET_STRING.length(); index++) {
            vowelList.add(TARTGET_STRING.charAt(index));
        }
        sIndexList.clear();
        sNumberList.clear();
        for (int index = 0; index < input.length(); index++) {
            if (vowelList.contains(input.charAt(index))) {
                sIndexList.add(index);
                sNumberList.add(index - sNumberList.size());
            }
        }
        int result = 0;
        for (int index = 0; index < sIndexList.size(); index++) {
            result = Math.max(process(index, sIndexList.size(), index, flaw), result);
        }
        return result;
    }

    private static int process(int start, int end, int now, int flaw) {
        int current = (start + end) / DIVIDE_NUM;
        if (current == start) {
            return (sNumberList.get(current) - sNumberList.get(now) == flaw)
                    ? sIndexList.get(current) - sIndexList.get(now) + ADD_NUM : 0;
        }
        int startTemp = start;
        int endTemp = end;
        if (sNumberList.get(current) - sNumberList.get(now) > flaw) {
            endTemp = current;
        } else {
            startTemp = current;
        }
        return process(startTemp, endTemp, now, flaw);
    }
}