package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//题目描述:给定k个数组，实现迭代器进行循环输出，例如[1,2,3]，[4,5,6,7]，[8,9],输出[1,4,8,2,5,9,3,6,7].
//解法描述:保存每个数组的迭代器，已经当前迭代输出的下标，list只要不为空，说明还有迭代器有值

public class ZigzagIterator {

    private List<Iterator<Integer>> list;
    private int index;

    public ZigzagIterator(List<List<Integer>> vecs) {
        this.index = 0;
        this.list = new ArrayList<Iterator<Integer>>();
        for (int i = 0; i < vecs.size(); ++i) {
            // 迭代器必须有值才能加入
            if (vecs.get(i)
                    .iterator()
                    .hasNext()) {
                this.list.add(vecs.get(i)
                        .iterator());
            }
        }
    }

    public int next() {
        int value = list.get(index)
                .next();
        if (list.get(index)
                .hasNext()) {
            index = ++index % list.size();
        } else {
            // 迭代器没有值了，就删除
            list.remove(index);
            if (!list.isEmpty()) {
                index %= list.size();
            }
        }

        return value;
    }

    public boolean hasNext() {
        // list不为空，说明迭代器还有值
        return !list.isEmpty();
    }
}
