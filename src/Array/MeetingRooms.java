package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
}
