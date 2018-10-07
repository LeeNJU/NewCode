package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//题目描述:模拟最大栈，类似于min stack
//解法描述:类似于min stack的解法，也可以用一个list保存所有数据，然后用一个treemap保存

public class MaxStack {

    private Stack<Integer> maxStack;
    private Stack<Integer> stack;

    public MaxStack() {
        maxStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }

        stack.push(x);
    }

    public int pop() {
        if (stack.peek()
                .equals(maxStack.peek())) {
            maxStack.pop();
        }

        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        List<Integer> list = new ArrayList<Integer>();

        while (!stack.peek()
                .equals(max)) {
            list.add(stack.pop());
        }

        stack.pop();
        for (int i = list.size() - 1; i >= 0; --i) {
            push(list.get(i));
        }

        return max;
    }
}
