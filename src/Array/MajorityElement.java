package Array;

//题目描述：给定一个数组，其长度为n，找到其中出现次数大于n/2的元素，假设数组非空，并且一定存在这样的元素
//解法描述：用candidate表示最后的结果，count表示candidate出现的次数，遍历数组，如果count等于0，那么candidate
//         为nums[i]，count加1，如果count不等于0并且candidate等于nums[i]，那么count加1，如果candidate不等
//         于nums[i]，就把count减1，如果candidate不是最后要找的元素，那么一定会碰到足够多的其他元素使得这个
//         candidate的count为0，如果candidate就是最后要找的元素，那么candidate的count会减少，但不会等于0

import java.util.List;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;

        for (int num : nums) {
            if (count == 0) {
                count = 1;
                result = num;
                continue;
            }

            count = num == result ? count + 1 : count - 1;
        }

        return result;
    }

    // 题目描述:找到数组中出现次数大于n / 3的元素,假设数组中只有一个这样的元素
    // 解法描述:解法与上题类似，现在要用两个top candidate元素来筛选

    public int majorityNumber(List<Integer> nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                ++count1;
            } else if (num == candidate2) {
                ++count2;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                ++count1;
            } else if (num == candidate2) {
                ++count2;
            }
        }

        return count1 > count2 ? candidate1 : candidate2;
    }
}
