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

/*

Smallest sequence with given Primes
Problem Description

Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.



Problem Constraints
1 <= A, B, C <= 10000

1 <= D <= 100000



Input Format
First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer D.



Output Format
Return an integer array of size D, denoting the first D integers described above.

NOTE: The sequence should be sorted in ascending order



Example Input
Input 1:

 A = 2
 B = 3
 C = 5
 D = 5
Input 2:

 A = 3
 B = 2
 C = 7
 D = 3


Example Output
Output 1:

 [2, 3, 4, 5, 6]
Output 2:

 [2, 3, 4]


Example Explanation
Explanation 1:

 4 = A * A ( 2 * 2 ), 6 = A * B ( 2 * 3 )
Explanation 2:

 2 has only prime factor 2. Similary 3 has only prime factor 3. 4 = A * A ( 2 * 2 )

 */