package HashTable;

import java.util.HashMap;

//题目描述:给定一个数组和一个k值，找到连续子数组的个数，使得子数组的和是k，例如nums = [1,1,1], k = 2，有两个连续子数组的和是k，返回2
//解法描述:hashmap保存sum出现的频率

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int result = 0;
        // 注意这里，保存第一次出现的次数
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
