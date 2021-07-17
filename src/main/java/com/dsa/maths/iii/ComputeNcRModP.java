package com.dsa.maths.iii;

public class ComputeNcRModP {
    private long[] fact;

    public int solve(int n, int r, int p) {
        constructFactorialArray(n, p);

        long ans = (inverseMod(fact[n - r], p) % p) * (inverseMod(fact[r], p) % p);
        long ans1 = (fact[n] * (ans % p));
        return (int) (ans1 % p);
    }

    private void constructFactorialArray(int n, int p) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }
    }

    private long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return a;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p) % p;
        }
        return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
    }

    private long inverseMod(long a, int p) {
        return power(a, p - 2, p);
    }
}
/*
Compute nCr % p
Problem Description

Given three integers A, B and C, where A represents n, B represents r and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.



Problem Constraints
1 <= A <= 106
1 <= B <= A
A <= C <= 109+7


Input Format
The first argument given is the integer A ( = n).
The second argument given is the integer B ( = r).
The third argument given is the integer C ( = p).



Output Format
Return the value of nCr % p.



Example Input
Input 1:

 A = 5
 B = 2
 C = 13
Input 2:

 A = 6
 B = 2
 C = 13


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 nCr( n=5 and r=2) = 10.
 p=13. Therefore, nCr%p = 10.
 */
