package BinarySearch;

import java.util.Map;
import java.util.TreeMap;

import Util.Interval;

//题目描述:给定一组interval，interval j被称作是interval i的右边，如果interval j的起始位置大于等于interval i
//        的结束位置，对每个interval，找到最接近的"right"interval的下标，例如[ [3,4], [2,3], [1,2] ]， 那
//        么返回[-1, 0, 1]，某个interval不存在"right" interval，就是-1
//解法描述:记录每个interval起始位置以及下标，对于每个interval的结束位置，找到最接近的起始位置，二分查找，

public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < intervals.length; ++i) {
            treeMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
