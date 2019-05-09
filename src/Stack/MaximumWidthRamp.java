package Stack;

import java.util.Stack;

//题目描述:给定一个整数数组，找到距离最远的两个元素i和j，使得A[i] <= A[j]并且i < j,例如[6,0,8,2,1,5]，满足要求的是(i, j) = (1, 5)，返回最长距离
//解法描述:用栈保存开头的递减元素，然后倒序扫描数组

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; ++i) {
            if (stack.isEmpty() || A[i] < A[stack.peek()]) {
                stack.push(i);
            }
        }

        int result = 0;
        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }

        return result;
    }
}
