package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个数组，定义数组的degree为元素出现的最多次数，找到最短的连续子数组，使得子数组的degree等于整个数组的degree，例如[1, 2, 2, 3, 1]，整个数组的degree是2，因为2出现了最多
//        的两次，连续的子数组有多个的degree都是2，例如[2, 2, 3], [2, 2]，但是最短的子数组是[2,2],返回最短的长度
//解法描述:遍历记录每个元素的出现次数，第一次出现位置，最后一次出现位置，因为最短的子数组第一位和最后一位一定是出现次数最多的数字，然后找到最短的

public class DegreeofanArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int degree = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 第一个是出现次数，第二个是第一次出现位置，第三个是最后一次出现位置
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] { 1, i, i });
            } else {
                int[] array = map.get(nums[i]);
                ++array[0];
                array[2] = i;
            }

            degree = Math.max(degree, map.get(nums[i])[0]);
        }

        int result = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (degree == map.get(nums[i])[0]) {
                result = Math.min(result, map.get(nums[i])[2] - map.get(nums[i])[1] + 1);
            }
        }

        return result;
    }
}
