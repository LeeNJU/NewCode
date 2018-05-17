package Array;

import java.util.ArrayList;
import java.util.List;

import Util.Interval;

//题目描述：给定一组已经排好序的数字区间，向其中插入一个数字区间，如果有必要进行区间合并，例如给定[1,2],[3,5],
//         [6,7],[8,10],[12,16]，插入[4,9]，结果为[1,2],[3,10],[12,16]
//解法描述:构造一个新的结果数组result，把intervals和newInterval的结果相继加入到result中
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); ++i) {
            if (intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
            } else if (newInterval.end < intervals.get(i).start) {
                result.add(newInterval);
                for (int j = i; j < intervals.size(); ++j) {
                    result.add(intervals.get(j));
                }
                return result;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }

        result.add(newInterval);
        return result;
    }
}
