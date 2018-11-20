package Stack;

import java.util.HashMap;
import java.util.Stack;

//题目描述:设计一种基于栈的数据结构，push操作添加元素，pop操作返回出现次数最大的元素，如果最大次数的元素有多个，那么返回最近的元素
//解法描述:counter用来记录元素的频率，m的key是出现次数，value是出现相同次数的元素，用stack存储，m[1]表示出现一次的元素，如果一个元素出现n次，
//        把这个元素放入到m[1],m[2],m[3],...,m[n]中

public class MaximumFrequencyStack {

    public HashMap<Integer, Integer> counter = new HashMap<>();
    public HashMap<Integer, Stack<Integer>> m = new HashMap<>();
    public int maxFrequency = 0;

    public void push(int x) {
        // 更新最大次数
        int f = counter.getOrDefault(x, 0) + 1;
        counter.put(x, f);
        maxFrequency = Math.max(maxFrequency, f);

        if (!m.containsKey(f)) {
            m.put(f, new Stack<Integer>());
        }

        m.get(f)
                .add(x);
    }

    public int pop() {
        int x = m.get(maxFrequency)
                .pop();
        counter.remove(x);
        counter.put(x, maxFrequency - 1);
        if (m.get(maxFrequency)
                .size() == 0) {
            --maxFrequency;
        }
        return x;
    }
}
