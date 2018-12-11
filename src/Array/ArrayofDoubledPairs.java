package Array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//题目描述:给定一个长度是偶数的整数数组，判断是否能够重组数组，使得每个元素满足下列条件A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2
//解法描述:本质上就是找配对的元素，不过配对是按照2倍来配对，记录每个元素的出现次数，要注意正数和负数的处理

public class ArrayofDoubledPairs {

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Arrays.stream(A)
                .forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        for (int count : map.keySet()) {
            if (map.get(count) == 0) {
                continue;
            }

            // 负数要除以2，正数要乘以2，寻找配对元素
            int want = count < 0 ? count / 2 : count * 2;
            // 如果count是奇数，或者配对元素的个数太小
            if ((count < 0 && count % 2 == 1) || map.get(count) > map.getOrDefault(want, 0)) {
                return false;
            }

            map.put(want, map.get(want) - map.get(count));
        }

        return true;
    }
}
