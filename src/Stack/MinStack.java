package Stack;

import java.util.Stack;

//题目描述：设计一个栈，使得他能够支持pop，push，top和在常数时间内得到最小元素的getMin
//解法描述：MinStack内部用标准stack来实现，另外再维护一个minStack，用来追踪最小元素

public class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }

        stack.push(x);
    }

    public void pop() {
        // 注意这里 Integer是对象，比较要用equals
        if (stack.peek()
                .equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
