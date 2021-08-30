package com.dsa.hashing.ii;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Equal {
    public int[] equal(int[] A) {

        //key: sum, value: list of pairs
        //insertion order should be maintained, so take LinkedHashMap
        Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new LinkedHashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];

                Pair<Integer, Integer> p = new Pair<>(i, j);
                ArrayList<Pair<Integer, Integer>> value = map.getOrDefault(sum, new ArrayList<>());
                value.add(p);

                map.put(sum, value);
            }
        }
        int[] ans = new int[4];
        Pair<Integer, Integer> p1 = null;
        Pair<Integer, Integer> p2 = null;

        for (Map.Entry<Integer, ArrayList<Pair<Integer, Integer>>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) { //check only when multiple pairs exist
                ArrayList<Pair<Integer, Integer>> value = entry.getValue();
                p1 = value.get(0);

                boolean found = false;
                for (int i = 1; i < value.size(); i++) {
                    p2 = value.get(i);
                    if (p1.x < p2.x && p1.y != p2.x && p1.y != p2.y) {//found satisfactory p2, so break
                        found = true;
                    }
                }
                if (found) { //found satisfactory p2, so break
                    break;
                }
            }
        }
        ans[0] = p1.x;
        ans[1] = p1.y;
        ans[2] = p2.x;
        ans[3] = p2.y;
        return ans;
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
