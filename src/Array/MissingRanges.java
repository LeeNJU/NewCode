package Array;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个已排序数组和一个上下界，找到其中缺失的区间，例如 [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
//解法描述:遍历数组，cur表示应该出现的下一个数字，如果和nums[i]相等，++cur，否则说明有一个缺失的区间,区间为[cur, nums[i] - 1],注意要判断cur和nums[i] - 1是否相等

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        long cur = lower;
        for (int i = 0; i < nums.length; ++i) {
            // z注意去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == cur) {
                ++cur;
                continue;
            }

            if (nums[i] - 1 == cur) {
                result.add(Long.toString(cur));
            } else {
                result.add(Long.toString(cur) + "->" + Integer.toString(nums[i] - 1));
            }

            // 防止溢出
            cur = (long) nums[i] + 1;
        }

        // 注意从结尾到upper还有遗漏的区间
        if (cur == upper) {
            result.add(Integer.toString(upper));
        } else if (cur < upper) {
            result.add(Long.toString(cur) + "->" + Integer.toString(upper));
        }

        return result;
    }
}
