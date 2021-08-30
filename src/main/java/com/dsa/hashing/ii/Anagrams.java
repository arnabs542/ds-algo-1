package com.dsa.hashing.ii;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        //map that stores sorted string and indices of occurrence
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < A.size(); i++) {
            char[] c = A.get(i).toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            ArrayList<Integer> value = map.getOrDefault(sorted, new ArrayList<>());
            value.add(i + 1);
            map.put(sorted, value); //key: sorted string, value: index+1
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            ans.add(new ArrayList<>(entry.getValue()));
        }
        return ans;
    }
}
