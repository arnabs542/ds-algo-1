package com.dsa.sorting.ii;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {

        Comparator<Integer> customComparator = (s1, s2) -> {
            String a = Integer.toString(s1);
            String b = Integer.toString(s2);
            return (b + a).compareTo(a + b);//custom sort to check if ab > ba
        };
        Collections.sort(A, customComparator);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < A.size(); i++) {
            if (!(A.get(i) == 0 && ans.length() == 0)) {//to avoid leading zeroes
                ans.append(A.get(i));
            }
        }

        if (ans.length() == 0) {//occurs when all elements are 0's
            ans.append("0");
        }
        return ans.toString();
    }
}

