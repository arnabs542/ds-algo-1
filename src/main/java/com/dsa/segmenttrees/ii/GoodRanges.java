package com.dsa.segmenttrees.ii;

import java.util.ArrayList;
import java.util.HashSet;

public class GoodRanges {

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {

        int mod = 1000000007;

        ArrayList<Integer> ans = new ArrayList<>();
        int sum = A + 1;
        int min = B.get(0);
        int max = B.get(0);

        ans.add(sum);

        HashSet<Integer> set = new HashSet<>();
        set.add(B.get(0));

        for (int i = 1; i < B.size(); i++) {

            if (!set.contains(B.get(i))) {
                set.add(B.get(i));

                sum = (sum + B.get(i)) % mod;

                if (B.get(i) < min) {
                    sum = (sum + min) % mod;
                    min = B.get(i);
                } else if (B.get(i) > max) {
                    sum = (sum + max) % mod;
                    max = B.get(i);
                } else {
                    sum = (sum + B.get(i)) % mod;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
