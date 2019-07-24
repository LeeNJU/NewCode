package TwoPointers;

import java.util.ArrayList;
import java.util.List;

import Util.Interval;

//题目描述:给定k个已经排好序的interval的list，进行合并，例如list1 = [(1,2),(3,4)] and list2 = [(4,5),(6,7)]，合并成[(1,2),(3,5),(6,7)]
//解法描述:利用归并排序的思路，也可以用最小堆

public class MergeKSortedIntervalLists {

    private void addAndMerge(List<Interval> list, Interval interval) {
        if (list.isEmpty() || list.get(list.size() - 1).end < interval.start) {
            list.add(interval);
        } else {
            list.get(list.size() - 1).end = Math.max(list.get(list.size() - 1).end, interval.end);
        }
    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> list = new ArrayList<Interval>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            Interval interval = list1.get(i).start < list2.get(j).start ? list1.get(i++) : list2.get(j++);
            addAndMerge(list, interval);
        }

        while (i < list1.size()) {
            addAndMerge(list, list1.get(i++));
        }

        while (j < list2.size()) {
            addAndMerge(list, list2.get(j++));
        }

        return list;
    }

    private List<Interval> merge(List<List<Interval>> list, int i, int j) {
        if (i > j) {
            return new ArrayList<Interval>();
        } else if (i == j) {
            return list.get(i);
        } else {
            int mid = i + (j - i) / 2;
            return mergeTwoInterval(merge(list, i, mid), merge(list, mid + 1, j));
        }
    }

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        return merge(intervals, 0, intervals.size() - 1);
    }
}
