package Stack;

import java.util.Stack;

import javafx.util.Pair;

//题目描述:给定一个股票价格，返回之前股票价格小于当当前价格的天数，例如[100, 80, 60, 70, 60, 75, 85]，返回[1, 1, 1, 2, 1, 4, 6]
//解法描述:递减栈的做法，要注意的是，遇到75的时候，栈中的元素为[100,80,70]，第一个60的信息就会丢失，所以需要保存60的信息，所以栈需要保存股票价格,以及这个股票价格对应的结果，
//        也就是小于这个股票价格的天数，然后弹栈的时候进行累加

public class OnlineStockSpan {

    private Stack<Pair<Integer, Integer>> stack;

    public OnlineStockSpan() {
        stack = new Stack<Pair<Integer, Integer>>();
    }

    public int next(int price) {
        int result = 1;
        while (!stack.isEmpty() && stack.peek()
                .getKey() <= price) {
            result += stack.pop()
                    .getValue();
        }

        stack.add(new Pair<Integer, Integer>(price, result));
        return result;
    }
}
