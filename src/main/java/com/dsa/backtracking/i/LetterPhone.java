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
/*
Letter Phone
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints
1 <= |A| <= 10



Input Format
The only argument is a digit string A.



Output Format
Return a string array denoting the possible letter combinations.



Example Input
Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output
Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation
Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations.

 */
