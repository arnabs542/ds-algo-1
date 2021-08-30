package com.dsa.arrays;

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
        return interval2.start <= interval1.end && interval1.start <= interval2.end;
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

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

