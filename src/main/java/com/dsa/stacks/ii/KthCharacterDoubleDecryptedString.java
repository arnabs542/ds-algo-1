package com.dsa.stacks.ii;

import java.util.Stack;

public class KthCharacterDoubleDecryptedString {
    public String solve(String A, int B) {

        Stack<Pair<Character, Long>> stack = new Stack<>();
        long length = 0L;

        for (int i = 0; i < A.length(); i++) {

            if (length >= B) { //break when length of decrypted string exceeds B
                break;
            }
            if (A.charAt(i) < 60) {//char is a digit
                int start = i;
                while (i < A.length() && A.charAt(i) < 60) {// consider all consecutive digits
                    i++;
                }
                length = length * Integer.parseInt(A.substring(start, i));
                i--;
            } else {
                length++; //position of current char
                Pair<Character, Long> top = new Pair<>(A.charAt(i), length);
                stack.push(top);
            }
        }
        long mod = Long.valueOf(B); //refer class notes for logic
        while (mod != 0) {
            if (stack.peek().value > mod) {
                stack.pop();
            } else {
                mod = mod % stack.peek().value;
            }
        }
        return Character.toString(stack.peek().character);
    }

    static class Pair<T, U> {
        T character;
        U value;

        Pair(T character, U value) {
            this.character = character;
            this.value = value;
        }
    }
}
