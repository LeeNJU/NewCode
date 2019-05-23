package HashTable;

import java.util.HashMap;

//题目描述:给定一个整数数组，找到连续的子数组的个数，使得子数组的和能够被K整除，例如A = [4,5,0,-2,-3,1], K = 5，能够被K整数的子数组有5个，
//       [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//解法描述:prefixSum的思路，不同的是，如果(sum(i) - sum(j)) % k == 0,代表sum(i) % k == sum(j) % k,那么久不需要求prefixSum，只需要求prefixSum对K
//       取模的值就行了，用hashmap记录对prefixSum对K取模的频率

public class SubarraySumsDivisiblebyK {

    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int a : A) {
            sum += (sum + a) % K;
            // 防止sum成为负数
            if (sum < 0) {
                sum += K;
            }

            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
