package Array;

import java.util.HashMap;

//题目描述:给定一个只包含0和1的数组，求有多少个和为S的子数组，例如A = [1,0,1,0,1], S = 2，和为2的子数组有4个，[1,0,1,0,1]，[1,0,1,0,1]，[1,0,1,0,1]，[1,0,1,0,1]
//解法描述:遍历数组，求出preSum，用hashmap保存presum出现的次数

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 这里是考虑整个数组的和
        map.put(0, 1);
        int sum = 0;
        int result = 0;

        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            result += map.getOrDefault(sum - S, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
