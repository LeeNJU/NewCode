package HashTable;

import java.util.HashMap;

//题目描述:给定一个数组只包含0和1，找到最长的连续的子数组，使得子数组中0和1的个数相同，例如[0,1,0],最长的连续子数组是[0,1]和[1,0],返回2
//解法描述:把0变成-1，就变成了找到最长的连续子数组，使得它们的和是0，遍历数组，用hashmap保存sum和对应的下标

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 注意这里，是为了考虑整个数组满足条件
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int index = map.get(sum);
                result = Math.max(result, i - index);
            }
        }

        return result;
    }
}
