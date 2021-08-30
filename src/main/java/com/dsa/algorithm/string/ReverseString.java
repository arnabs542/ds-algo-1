package com.dsa.algorithm.string;

public class ReverseString {
    public String solve(String A) {

        char[] c = A.toCharArray();
        reverse(0, c.length - 1, c);

        int start = 0;
        int end = 0;

        while (start < c.length) {
            while (end < c.length && c[end] != ' ') {
                end++;
            }
            reverse(start, end - 1, c);
            start = end + 1;
            end = start;
        }
        return trimSpaces(c);

//        String[] s = A.split(" "); //split words by space
//
//        StringBuffer ans = new StringBuffer("");
//        for (int i = s.length - 1; i >= 0; i--) { //iterate from backwards
//            if (s[i].trim().length() > 0) {
//                ans.append(s[i]);
//                ans.append(" ");
//            }
//        }
//        return ans.toString().trim();
    }

    private String trimSpaces(char[] s) {
        int left = 0;
        int right = s.length - 1;

        StringBuilder ans = new StringBuilder();

        while (left <= right && s[left] == ' ') {
            left++;
        }
        while (left <= right && s[right] == ' ') {
            right--;
        }

        while (left <= right) {
            if (s[left] != ' ') {
                ans.append(s[left]);
                left++;
            } else {
                ans.append(' ');
                while (left <= right && s[left] == ' ') {
                    left++;
                }
            }
        }
        return ans.toString();
    }

    private void reverse(int start, int end, char[] s) {
        int i = start;
        int j = end;

        while (i < j) {
            char c = s[j];
            s[j--] = s[i];
            s[i++] = c;
        }
    }
}
