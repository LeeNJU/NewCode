package Stack;

import java.util.Stack;

//题目描述:给定一个数组，判断数组是否满足以下pattern，i < j < k, and nums[i] < nums[k] < nums[j]
//解法描述:用一个栈，倒序遍历

public class Pattern {

    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = nums.length - 1; i >= 0; --i) {
            // nums[i] < nums[k]
            if (nums[i] < third) {
                return true;
            }

            // 当前元素比栈里的元素大，出栈，并更新third，这样可以满足nums[k] < nums[j]
            while (!stack.empty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.add(nums[i]);
        }
        return false;
    }
}
