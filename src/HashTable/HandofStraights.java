package HashTable;

import java.util.Arrays;
import java.util.TreeMap;

//题目描述:给定一个整数数组和一个W值，判断能不能把数组分成W个group，每个group包含W个连续的数字，例如hand = [1,2,3,6,2,3,4,7,8], W = 3，可以分成
//        [1,2,3],[2,3,4],[6,7,8].
//解法描述:treemap统计元素的次数，然后遍历

public class HandofStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Arrays.stream(hand)
                .forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        for (int key : map.keySet()) {
            if (map.getOrDefault(key, 0) == 0) {
                continue;
            }

            int count = map.get(key);
            for (int i = key; i < key + W; ++i) {
                if (map.getOrDefault(i, 0) < count) {
                    return false;
                }

                map.put(i, map.get(i) - count);
            }
        }

        return true;
    }
}
