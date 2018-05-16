package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Util.Interval;

//题目描述:给定一个Interval数组，将重复的合并，例如[1,3],[2,6],[8,10],[15,18],结果为[1,6],[8,10],[15,18]
//解法描述:先按照interval的start进行排序，然后0到i表示已经合并好的最后interval，j表示要合并当前interval，比较
//        end的值，如果有重复，把intervals[j]合并到intervals[i]，如果没有重复，i向后移动，把intervals[j]的
//        值赋给i

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(Interval::getStart));
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));

        int j = 0;
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start <= result.get(j).end) {
                result.get(j).end = Math.max(result.get(j).end, intervals.get(i).end);
            } else {
                result.add(intervals.get(i));
                ++j;
            }
        }

        return result;
    }
}
