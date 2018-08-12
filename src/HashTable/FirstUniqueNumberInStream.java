package HashTable;

import java.util.HashMap;

//题目描述: 给定一个整数流和一个终结数字number，找到在终结数字出现之前的数字流中第一个唯一的数字，例如Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 5
//        return 3，没有返回-1，如果终结数字在流中不存在也返回-1
//解法描述:

public class FirstUniqueNumberInStream {

    public int firstUniqueNumber(int[] nums, int number) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = -1;
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // 记录终结数字的index
            if (number == nums[i]) {
                index = i;
                break;
            }
        }

        // 终结数字不存在
        if (index == -1) {
            return -1;
        }

        for (int i = 0; i <= index; ++i) {
            if (map.getOrDefault(nums[i], 0) == 1) {
                return nums[i];
            }
        }

        return -1;
    }
}
