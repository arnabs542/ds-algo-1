package com.arrays;

import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();

        boolean newIntervalAdded = false;

        for (int i = 0; i < intervals.size(); i++) {

            //overlapping can occur only when newInterval is not added
            if (!newIntervalAdded && checkIfOverlapping(intervals.get(i), newInterval)) {
                Interval merged = mergeTwoIntervals(intervals.get(i), newInterval);
                //change newInterval
                newInterval.start = merged.start;
                newInterval.end = merged.end;
            } else {
                // to avoid adding newInterval, once added means no more merging needed
                if (!newIntervalAdded) {
                    Interval smaller = getSmallerInterval(intervals.get(i), newInterval);

                    //if newInterval is the smaller one, add it but only once
                    if (smaller.start == newInterval.start && smaller.end == newInterval.end) {
                        newIntervalAdded = true;
                        ans.add(newInterval);
                    }
                }
                ans.add(intervals.get(i));
            }
        }

        //if newInterval not added even after all elements got traversed, meaning add it at the last
        if (!newIntervalAdded) {
            ans.add(newInterval);
        }
        return ans;
    }

    private boolean checkIfOverlapping(Interval interval1, Interval interval2) {
        if (interval2.start <= interval1.end && interval1.start <= interval2.end) {
            return true;
        }
        return false;
    }

    private Interval mergeTwoIntervals(Interval interval1, Interval interval2) {
        int start = Math.min(interval1.start, interval2.start);
        int end = Math.max(interval1.end, interval2.end);

        return new Interval(start, end);
    }

    private Interval getSmallerInterval(Interval interval1, Interval interval2) {
        if (interval1.end < interval2.start) {
            return interval1;
        }
        return interval2;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}


/*
Problem Description

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
1 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */