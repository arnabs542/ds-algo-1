package com.dsa.backtracking.i;

import java.util.*;

public class LetterPhone {

    private final ArrayList<String> ans = new ArrayList<>();
    private static final Map<Integer, List<Character>> digitToCharMap;

    static {
        digitToCharMap = new HashMap<>();
        digitToCharMap.put(0, Arrays.asList('0'));
        digitToCharMap.put(1, Arrays.asList('1'));
        digitToCharMap.put(2, Arrays.asList('a', 'b', 'c'));
        digitToCharMap.put(3, Arrays.asList('d', 'e', 'f'));
        digitToCharMap.put(4, Arrays.asList('g', 'h', 'i'));
        digitToCharMap.put(5, Arrays.asList('j', 'k', 'l'));
        digitToCharMap.put(6, Arrays.asList('m', 'n', 'o'));
        digitToCharMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        digitToCharMap.put(8, Arrays.asList('t', 'u', 'v'));
        digitToCharMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public ArrayList<String> letterCombinations(String A) {
        recurse(0, new StringBuilder(), A);
        return ans;
    }

    private void recurse(int currentIndex, StringBuilder str, String A) {

        if (currentIndex == A.length()) {
            ans.add(str.toString());
            return;
        }

        List<Character> characters = digitToCharMap.get(Integer.parseInt("" + A.charAt(currentIndex)));

        for (int j = 0; j < characters.size(); j++) {
            str.append(characters.get(j));
            recurse(currentIndex + 1, str, A);
            str.deleteCharAt(str.length() - 1);//backtrack for other possibilities
        }
    }
}

