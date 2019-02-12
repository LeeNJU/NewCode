package TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import Util.Interval;

//题目描述:给定两个interval的数组，interval已经排好序，求出它们的交集
//解法描述:双指针

public class IntervalListIntersections {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int i = 0, j = 0;
        List<Interval> list = new ArrayList<Interval>();

        while (i < A.length && j < B.length) {
            if (A[i].end < B[j].start) {
                ++i;
            } else if (A[i].start > B[j].end) {
                ++j;
            } else {
                // 注意这里求交集的方式
                Interval interval = new Interval(Math.max(A[i].start, B[j].start), Math.min(A[i].end, B[j].end));
                list.add(interval);

                // 一个interval可能与多个interval有交集
                if (A[i].end < B[j].end) {
                    ++i;
                } else {
                    ++j;
                }
            }
        }

        Interval[] intervals = new Interval[list.size()];
        IntStream.range(0, list.size())
                .forEach(index -> {
                    intervals[index] = list.get(index);
                });

        return intervals;
    }
}
