package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Util.Interval;

//题目描述:给定一个数组interval表示时间，判断这些interval有没有重复
//解法描述:先按照start进行排序，然后两两比较判断是否有重复

public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStart));

        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }

    // 题目描述:给定一组开会的开始和结束时间，最少需要几个会议室
    // 解法描述:把不重叠的会议安排在同一个会议室，先按照开始时间排序，用最小堆保存interval的结束时间，遍历之前的interval，看是否能把当前interval放入到同一个会议室中，
    // 最后最小堆的大小就是结果
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStart));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        intervals.stream()
                .forEach(interval -> {
                    if (!queue.isEmpty() && queue.peek() <= interval.start) {
                        queue.poll();
                    }

                    queue.add(interval.end);
                });

        return queue.size();
    }
}
