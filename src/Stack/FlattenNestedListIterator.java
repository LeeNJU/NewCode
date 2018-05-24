package Stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Util.NestedInteger;

//题目描述:给定一个嵌套链表，将其扁平化，调用hasNext返回true如果还有元素，否则返回false，调用next返回当前元素
//        例如[[1,1],2,[1,1]],扁平化后应该是[1,1,2,1,1]
//解法描述:用一个栈，先把元素逆序存入栈中，hasnext方法中，如果当前元素不是一个整数，那么就是一个链表，把链表
//        的元素一次压入栈中，直到栈为空或者当前栈顶元素为一个整数为止。

public class FlattenNestedListIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<NestedInteger>();;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger = stack.pop();
        return nestedInteger.getInteger();
    }

    // 注意，应该修改hasNext方法，这样可以处理空[]的情况
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger nestedInteger = stack.peek();
            if (nestedInteger.isInteger()) {
                return true;
            }

            nestedInteger = stack.pop();
            for (int i = nestedInteger.getList()
                    .size() - 1; i >= 0; --i) {
                stack.push(nestedInteger.getList()
                        .get(i));
            }
        }

        return false;
    }
}
