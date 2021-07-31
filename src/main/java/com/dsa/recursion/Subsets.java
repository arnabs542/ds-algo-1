package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        getAllSubsets(new ArrayList<>(), 0, A);
        return ans;
    }

    //consider all choices available at currentIndex position of the currentSet
    private void getAllSubsets(ArrayList<Integer> currentSet, int currentIndex, ArrayList<Integer> A) {

        ans.add(new ArrayList<>(currentSet)); //add currentSet to result

        //pick next element among the choices and recurse, after returning unpick added element and consider next choices
        for (int i = currentIndex; i < A.size(); i++) {
            currentSet.add(A.get(i));
            getAllSubsets(currentSet, i + 1, A);
            currentSet.remove(currentSet.size() - 1);
        }
    }

    /* Approach of picking one, recurse, then unpick and backtrack
    private void allSubsets(int[] A, ArrayList<Integer> currList, int currIndex) {

        if (currIndex == A.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        currList.add(A[currIndex]);
        allSubsets(A, currList, currIndex + 1);

        currList.remove(currList.size() - 1);
        allSubsets(A, currList, currIndex + 1);
    }*
    /

    /* Without back tracking (by sorting final answer array again)
    static class Sort2DArrayList implements Comparator<ArrayList<Integer>> {

        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {

            int minLength = Math.min(list1.size(),list2.size());
            int i = 0;

            while(i < minLength){
                if(list1.get(i) != list2.get(i)){
                    return list1.get(i)-list2.get(i);
                }
                i++;
            }
            return list1.size()-list2.size();
        }
    }

    private ArrayList<Integer> set = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        set.addAll(A);

        getAllSubsets(new ArrayList<>(), 0);

        Collections.sort(ans, new Sort2DArrayList());
        return ans;
    }

    private void getAllSubsets(ArrayList<Integer> currentSet, int currentIndex) {

        if (currentIndex == set.size()) {
            ans.add(new ArrayList<>(currentSet));
            return;
        }

        currentSet.add(set.get(currentIndex)); //add currentIndex element
        getAllSubsets(currentSet, currentIndex + 1); //get all subsets including currentIndex element

        currentSet.remove(currentSet.size() - 1); //need to remove added element
        getAllSubsets(currentSet, currentIndex + 1); //get all subsets excluding currentIndex element
    }

     */
}

/*
Subset
Problem Description

Given a set of distinct integers, A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation
Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.

 */
