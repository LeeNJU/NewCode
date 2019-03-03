package HashTable;

import java.util.Arrays;
import java.util.HashMap;

//题目描述:给定一个整数数组，定义这样的sequence，它的最大值比最小值大1，找到数组中长度最长的sequence，例如[1,3,2,2,5,2,3,7]，长度为5，[3,2,2,2,3]
//解法描述:其实很简单，求的是sequence，不在乎顺序，只在乎个数，保存每个值出现的次数，依次遍历，找到key + 1的次数，然后求最大

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.stream(nums)
                .forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        int length = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);

            if (map.containsKey(key + 1)) {
                length = Math.max(length, count + map.get(key + 1));
            }
        }

        return length;
    }
}
