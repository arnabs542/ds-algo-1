package com.dsa.sorting.i;

public class WaveArray {
    public void wave(int[] nums) {

        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length - 1; i += 2) {
        // swap(i, i + 1, nums);
        // }

        for (int i = 0; i < nums.length; i += 2) {
            if (i != 0 && nums[i] > nums[i - 1]) {
                swap(i, i - 1, nums);
            }
            if (i != nums.length - 1 && nums[i] > nums[i + 1]) {
                swap(i, i + 1, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}

