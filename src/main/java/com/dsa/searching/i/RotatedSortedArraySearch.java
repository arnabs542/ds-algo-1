package com.dsa.searching.i;

public class RotatedSortedArraySearch {
    public int search(final int[] A, int B) {

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {

            // to avoid duplicates
            while (l < r && A[l] == A[l + 1]) {
                l++;
            }
            while (l < r && A[r] == A[r - 1]) {
                r--;
            }

            int mid = l + (r - l) / 2;

            if (A[mid] == B) {
                return mid;
            }
            if (A[mid] >= A[l]) {
                if (A[mid] > B && A[l] <= B) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[mid] < B && A[r] >= B) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

        //rotated array -> 4,5,6,1,2,3 pivoted at index 3
        //sorted array -> 1,2,3,4,5,6
//        int pivotIndex = findPivotIndex(A);
//
//        // System.out.println("DSFSD " + pivotIndex);
//        int l = 0;
//        int r = A.length - 1;
//
//        while (l <= r) {
//
//            int mid = l + ((r - l) / 2);
//            //mid of rotated array is translated into its corresponding position in sorted array
//            int newMid = (mid + pivotIndex) % (A.length); //this is done to apply binary search on sorted array instead of rotated array
//
//            if (A[newMid] > B) {
//                r = mid - 1;
//            } else if (A[newMid] < B) {
//                l = mid + 1;
//            } else {
//                return newMid;
//            }
//        }
//        return -1;
    }

    //Binary search to find pivot index
    private int findPivotIndex(int[] A) {
        int l = 0;
        int r = A.length - 1;

        int pivot = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (A[mid] >= A[0]) { //if >= first element pivot will be in right half
                l = mid + 1;
            } else if (A[mid] < A[0]) { // if < first element, this can be the pivot or will be in left half
                pivot = mid;
                r = mid - 1;
            }
//            if (A[mid] > A[A.length - 1]) { //if > last element pivot will be in right half
//                l = mid + 1;
//            } else if (A[mid] <= A[A.length - 1]) { // if <= last element, this can be the pivot or will be in left half
//                pivot = mid;
//                r = mid - 1;
//            }
        }
        return pivot;
    }
}

