package HashTable;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//题目描述:给定一些trip还有汽车的最大载客量capacity，每一个trip包含起始地点和终止地点以及乘客数量，判断能不能完成所有的trip，例如trips = [[2,1,5],[3,3,7]], capacity = 5
//解法描述:和Calender的题类似，按照时间顺序记录每个时间点的乘客数量，判断能否完成所有trip

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Arrays.stream(trips)
                .forEach(trip -> {
                    map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
                    map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
                });

        for (int time : map.keySet()) {
            capacity -= map.get(time);
            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }
}
