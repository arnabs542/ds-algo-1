package com.dsa.backtracking.ii;

import java.util.HashMap;

//leet code implementation
public class MinimumSwapsToArrangePairs {

    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int partner = row[i] ^ 1;
            if (row[i + 1] == partner)
                continue;

            ans++;
            int partnerIndex = map.getOrDefault(partner, -1);

            //update map indices and swap
            map.put(partner, i + 1);
            map.put(row[i + 1], partnerIndex);
            swap(row, i + 1, partnerIndex);
        }
        return ans;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

