package Array;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个没有重复元素的已序数组，返回范围，例如[0,1,2,4,5,7]，返回["0->2","4->5","7"]
//解法描述:用first和last来表示一个范围,遍历数组的时候，last表示下一位应该出现的元素，如果当前元素与last不等
//        说明找到了一个区间

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int first = nums[0], last = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (last + 1 == nums[i]) {
                last = nums[i];
                continue;
            }

            if (first == last) {
                result.add(Integer.toString(first));
            } else {
                result.add(first + "->" + last);
            }

            first = nums[i];
            last = nums[i];
        }

        if (first == last) {
            result.add(Integer.toString(first));
        } else {
            result.add(first + "->" + last);
        }

        return result;
    }
}
