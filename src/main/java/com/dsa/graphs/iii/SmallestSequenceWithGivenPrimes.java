package com.dsa.graphs.iii;

import java.util.ArrayList;
import java.util.TreeSet;

public class SmallestSequenceWithGivenPrimes {

    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();

        TreeSet<Integer> set = new TreeSet<>();
        set.add(A);
        set.add(B);
        set.add(C);

        for (int i = 0; i < D; i++) {
            int temp = set.first();
            set.remove(temp);
            res.add(temp);

            set.add(temp * A);
            set.add(temp * B);
            set.add(temp * C);
        }
        return res;
    }

//    public ArrayList<Integer> solve(int A, int B, int C, int D) {

//         ArrayList<Integer> res = new ArrayList<>();
//         res.add(1);
//         int a, b, c;
//         a = b = c = 0;

//         for (int i = 0; i < D; i++) {
//             int mA = res.get(a) * A;
//             int mB = res.get(b) * B;
//             int mC = res.get(c) * C;

//             int min = Math.min(mA, mB);
//             min = Math.min(min, mC);

//             res.add(min);

//             if (min == mA)
//                 a++;

//             if (min == mB)
//                 b++;

//             if (min == mC)
//                 c++;
//         }

//         res.remove(0);
//         return res;
//     }
}

