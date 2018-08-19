package Array;

import java.util.TreeMap;

//题目描述:实现一个calender，支持以下功能，加入一个interval，如果没有重复的interval，返回true，如果有重复的interval返回false
//解法描述:treemap进行排序，再判断是否重复

public class MyCalendar {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) {
            return false;
        }

        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }

        calendar.put(start, end);
        return true;
    }
}
