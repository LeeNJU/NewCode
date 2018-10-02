package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//题目描述:给定一个二维数组，实现next和hashNext函数
//解法描述:保存每个一维数组的迭代器

public class Flatten2DVector implements Iterator<Integer> {

    private List<Iterator<Integer>> list;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.list = new ArrayList<Iterator<Integer>>();
        for (int i = 0; i < vec2d.size(); ++i) {
            if (vec2d.get(i)
                    .iterator()
                    .hasNext()) {
                list.add(vec2d.get(i)
                        .iterator());
            }
        }
    }

    @Override
    public Integer next() {
        int value = list.get(0)
                .next();
        if (!list.get(0)
                .hasNext()) {
            list.remove(0);
        }

        return value;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public void remove() {
    }
}
