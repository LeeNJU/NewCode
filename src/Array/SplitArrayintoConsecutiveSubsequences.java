package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//题目描述:给定已排序的数组，可能有重复元素，判断是不是能把数组分成长度大于等于3的连续的子序列，例如[1,2,3,3,4,4,5,5]，可以分成[1,2,3,4,5]和[3,4,5]
//解法描述:扫描数组，对于每一个元素，有两种可能，要么可以把该数字加入到已知序列，形成更长的序列，要么该数字作为序列的起点，用map保存数字的出现次数，need保存
//       该数字可以加到已知序列的末尾的个数，即有几个序列需要这个数字

public class SplitArrayintoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> need = new HashMap<Integer, Integer>();

        Arrays.stream(nums)
                .forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 0) {
                continue;
                // 该数字可以加到已知序列的末尾
            } else if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num + 2, 0) > 0) {
                map.put(num + 1, map.get(num + 1) - 1);
                map.put(num + 2, map.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }

            map.put(num, map.get(num) - 1);
        }

        return true;
    }
}
