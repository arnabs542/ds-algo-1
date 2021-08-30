package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BthSmallestPrimeFraction {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        ArrayList<Pair<Integer, Integer>> fractions = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) < A.get(j)) {
                    fractions.add(new Pair<>(A.get(i), A.get(j)));
                }
            }
        }

        Comparator<Pair<Integer, Integer>> customComparator = (a, b) -> {
            Double fracA = ((double) a.num) / a.denom;
            Double fracB = ((double) b.num) / b.denom;
            return fracA.compareTo(fracB);
        };

        Collections.sort(fractions, customComparator);
        return new ArrayList<>(Arrays.asList(fractions.get(B - 1).num, fractions.get(B - 1).denom));
    }

    static class Pair<T, U> {
        T num;
        U denom;

        Pair(T t, U u) {
            this.num = t;
            this.denom = u;
        }
    }
}

