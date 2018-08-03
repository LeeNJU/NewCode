package Array;

import java.util.HashMap;

//题目描述:给定一个数组，找到一个下标，使得下标左边元素的和等于下标右边元素的和，例如[1, 7, 3, 6, 5, 6]，返回下表3，因为1 + 7 + 3 = 5 + 6，如果有多个满足条件的下表，返回最左边的下标
//解法描述:hashmap保存下表对应的和，然后遍历

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            map.put(i, sum);
        }

        map.put(-1, 0);
        for (int i = 0; i < nums.length; ++i) {
            if (map.get(i - 1) == sum - nums[i] - map.get(i - 1)) {
                return i;
            }
        }

        return -1;
    }
}
