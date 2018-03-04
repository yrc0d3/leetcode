import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(-1, 11);
        List<Interval> ret = new InsertInterval().insert(intervals, newInterval);
        ret.forEach(interval -> System.out.println(interval.start + ", " + interval.end));
    }

    // using Problem MergeIntervals' solution
    // insert newInterval, then merge
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        while (index < intervals.size() && newInterval.start >= intervals.get(index).start) {
            index++;
        }
        intervals.add(index, newInterval);

        List<Interval> ret = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval.start > prev.end) {
                ret.add(prev);
                prev = interval;
            } else {
                prev.end = Math.max(prev.end, interval.end);
            }
        }
        ret.add(prev);

        return ret;
    }

    private static class Interval {
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
