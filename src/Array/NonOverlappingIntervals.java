package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Util.Interval;

//题目描述:给定一个interval数组，删除其中的某些interval，使得所有的interval没有重叠，例如Input: [ [1,2], [2,3], [3,4], [1,3] ]，返回1，因为可以删除[1,3]
//解法描述:先排序然后遍历，总是选择end较大的interval然后删除

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return 0;
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        int count = 0;
        Interval interval = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start >= interval.end) {
                interval = intervals.get(i);
                continue;
            }

            ++count;
            interval = interval.end < intervals.get(i).end ? interval : intervals.get(i);
        }

        return count;
    }
}
