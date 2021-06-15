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
/*
kth character in double decrypted string
Given a String A and an integer B. String A is encoded consisting of lowercase English letters and numbers. A is encoded in a way where repetitions of substrings are represented as substring followed by the count of substrings.

For example: if the encrypted string is “ab2cd2” and B=6, so the output will be ‘d’ because the decrypted string is “ababcdababcd” and 4th character is ‘b’.

You have to find and return the Bth character in the decrypted string.

Note: Frequency of encrypted substring can be of more than one digit. For example, in “ab12c3”, ab is repeated 12 times. No leading 0 is present in the frequency of substring.

Input Format

The arguments given are string A and integer B.
Output Format

Return the Bth character in the decrypted string.
Constraints

1 <= length of the array <= 10^5
1 < = K < = 10^9
For Example

Input 1:
    A = "ab2c3"
    B = 8
Output 1:
    a
    Decrypted string will be "ababcababcababc" and 'a' is the 8th character.

Input 2:
    A = "x2y3"
    B = 3
Output 2:
    y
    Decrypted string will be "xxyxxyxxy"


 */