package com.dsa.hashing.ii;

import java.util.HashSet;
import java.util.Objects;

public class CountRectangles {
    public int solve(int[] A, int[] B) {

        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(new Pair<>(A[i], B[i])); //add all points to set
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) { //for every two points of one diagonal1, consider other two points of diagonal2
                Pair<Integer, Integer> p1 = new Pair<>(A[i], B[j]); //diagonal2 point1
                Pair<Integer, Integer> p2 = new Pair<>(A[j], B[i]); //diagonal2 point2

                if (A[i] != A[j] && B[i] != B[j]) { //other two points shouldn't turn out to be same as points under consideration
                    //check if points can be of diagonal1 then if p1 and p2 exist in the set
                    if (set.contains(p1) && set.contains(p2)) {
                        ans++;
                    }
                }
            }
        }
        return ans / 2; //take half, because we count each rectangle twice because of two diagonals
    }

    static class Pair<T, E> {
        T x;
        E y;

        Pair(T x, E y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(x, pair.x) &&
                    Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
