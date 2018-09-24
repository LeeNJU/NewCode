package Stack;

import java.util.Stack;

//题目描述:给定一组温度，对于每一个温度，求出下一个比它大的温度的距离，例如temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，返回[1, 1, 4, 2, 1, 1, 0, 0]
//解法描述:用递减栈的方法，栈中的元素是递减的，一旦碰到比栈顶元素大的元素，就可以算出距离，注意存的是下标

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.add(i);
        }

        return result;
    }
}
