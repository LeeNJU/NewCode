package Stack;

import java.util.Stack;

//题目描述:给定两个序列，不包含重复元素，对第一个序列，判断能否通过栈的push和pop操作得到第二个序列，例如pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//        push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1,可以得到第二个序列
//解法描述:用栈，来模拟操作

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        // 压入栈中
        for (int num : pushed) {
            stack.push(num);

            // 找到匹配的元素
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                ++index;
            }
        }

        return index == popped.length;
    }
}
