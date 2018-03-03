import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> ret = new MergeIntervals().merge(intervals);
        ret.forEach(interval -> System.out.printf("%d, %d\n", interval.start, interval.end));
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));
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
