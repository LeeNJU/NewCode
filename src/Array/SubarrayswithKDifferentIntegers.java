package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个数组和一个k值，找到数组中所有的子数组，使得每个子数组的unique元素的个数是K，例如A = [1,2,1,3,4], K = 3，这些数组[1,2,1,3], [2,1,3], [1,3,4]
//       都包含k个unique的元素，返回有多少个这样的子数组
//解法描述:要求子数组包含K个unique的元素，atMostK(K) - atMostK(K - 1)就是答案，atMostK返回子数组的个数，每个子数组最多包含K个不同的元素，可以用sliding window

public class SubarrayswithKDifferentIntegers {

    private int atMostK(int[] A, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for (int j = 0; j < A.length; ++j) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);

            while (map.size() > k) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    map.remove(A[i]);
                }

                ++i;
            }

            result += j - i;
        }

        return result;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

}
