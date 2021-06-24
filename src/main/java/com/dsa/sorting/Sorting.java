package com.dsa.sorting;

import java.util.Arrays;

public class Sorting {

    private int[] mergeSortAns;

    public int[] sortArray(int[] nums) {
        // selectionSort(nums);
        // bubbleSort(nums);
        // insertionSort(nums);
        // mergeSortAns = new int[nums.length];
        // mergeSort(0, nums.length - 1, nums);
        // quickSort(0, nums.length - 1, nums);
        // countSort(nums);
        radixSort(nums);
        return nums;
    }

    private void radixSort(int[] nums) {

        int negCount = 0, posCount = 0, negMax = Integer.MIN_VALUE, posMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negMax = Math.max(negMax, nums[i] * -1);
                negCount++;
            } else {
                posMax = Math.max(posMax, nums[i]);
                posCount++;
            }
        }
        final int[] negNums = new int[negCount];
        final int[] posNums = new int[posCount];

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negNums[j++] = nums[i] * -1;
            } else {
                posNums[k++] = nums[i];
            }
        }

        for (int exp = 1; negMax / exp > 0; exp *= 10) {
            countSortForPositiveNums(negNums, 10, exp);
        }
        for (int exp = 1; posMax / exp > 0; exp *= 10) {
            countSortForPositiveNums(posNums, 10, exp);
        }

        int i = 0;
        for (int j = negNums.length - 1; j >= 0; j--) {
            nums[i++] = negNums[j] * -1;
        }
        for (int j = 0; j < posNums.length; j++) {
            nums[i++] = posNums[j];
        }
    }

    private void countSortForPositiveNums(int[] nums, int range, int exp) {

        int output[] = new int[nums.length];

        int count[] = new int[range];

        for (int i = 0; i < nums.length; i++) {
            count[(nums[i] / exp) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //for stable, we iterate from back because count[i] indicates position of i but it was calc from left -> right
        //so now coming from backwards retains relative order
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    private void countSort(int[] nums) {

        int output[] = new int[nums.length];
        int min = Arrays.stream(nums).min().getAsInt();

        int count[] = new int[100002];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //for stable, we iterate from back because count[i] indicates position of i but it was calc from left -> right
        //so now coming from backwards retains relative order
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min]--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    private void quickSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int j = partition(left, right, nums);
        quickSort(left, j - 1, nums);
        quickSort(j + 1, right, nums);
    }

    private int partition(int left, int right, int[] nums) {

        int i = left;
        int j = right;

        int pivot = nums[left];
        while (i < j) {
            while (i < nums.length && nums[i] <= pivot) {
                i++;
            }
            while (j >= 0 && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(i, j, nums);
            }
        }
        swap(left, j, nums);
        return j;
    }

    private void mergeSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, nums);
        mergeSort(mid + 1, right, nums);
        merge(left, right, nums);
    }

    private void merge(int left, int right, int[] nums) {
        int mid = left + (right - left) / 2;

        int pointer1 = left;
        int pointer2 = mid + 1;

        int ansIndex = left;

        while (ansIndex <= right) {
            if ((pointer1 <= mid) && (pointer2 == right + 1 || nums[pointer1] <= nums[pointer2])) {
                mergeSortAns[ansIndex++] = nums[pointer1++];
            } else if ((pointer2 <= right) && (pointer1 == mid + 1 || nums[pointer1] > nums[pointer2])) {
                mergeSortAns[ansIndex++] = nums[pointer2++];
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = mergeSortAns[i];
        }
    }

    private void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, nums);
        }
    }

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 0; j + 1 < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    private void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
        }
    }

    //works only if indices are different, otherwise xor gives 0
    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }


}
