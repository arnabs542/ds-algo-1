package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        // sort the intervals in increasing order of start time
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        ArrayList<Interval> ans = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {

            //check if overlapping with last stored interval, if yes merge and update last stored interval values
            if (!ans.isEmpty() && checkIfOverlapping(ans.get(ans.size() - 1), intervals.get(i))) {

                Interval merged = mergeTwoIntervals(ans.get(ans.size() - 1), intervals.get(i));

                Interval last = ans.get(ans.size() - 1);
                last.start = merged.start;
                last.end = merged.end;

                ans.set(ans.size() - 1, last);
            } else {
                ans.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            }
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

    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
/*
Merge Overlapping Intervals
Problem Description

Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.

 */