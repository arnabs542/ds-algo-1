package com.dsa.maths.iii;

public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        

        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            result *= 26;
            result += A.charAt(i) - 'A' + 1;
        }
        return result;

        // A,B,C,D... correspond to 1,2,3,4
        // BA = 1*(26^0) + 2*(26^1)
//        int sum = 0;
//        for (int i = A.length() - 1; i >= 0; i--) {
//            int a = A.charAt(i) - 'A' + 1;
//            sum += a * Math.pow(26, A.length() - 1 - i);
//        }
//        return sum;
    }
}
