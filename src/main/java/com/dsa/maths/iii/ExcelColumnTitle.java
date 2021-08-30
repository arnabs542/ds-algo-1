package com.dsa.maths.iii;

public class ExcelColumnTitle {

    public String convertToTitle(int n) {

        
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int rem = n % 26; // rem will be btn 0->25, where 0->Z, 1->A, 2->B, .... 25->Y
            rem = (rem == 0) ? 26 : rem;
            ans.append((char) (rem + 'A' - 1));
            n = (n - rem) / 26; //subtract rem from n, as we need to remove contribution of current char in n
        }
        return ans.reverse().toString();
    }
}
