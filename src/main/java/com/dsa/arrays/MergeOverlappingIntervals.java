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
