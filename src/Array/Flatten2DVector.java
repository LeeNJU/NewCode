package Array;

import java.util.Iterator;
import java.util.List;

//题目描述:给定一个二维数组，实现next和hashNext函数
//解法描述:x和y分别代表行和列，hashNext的时候，要小心y不能超过当前列的下标。要注意考虑某一行是空的情况

public class Flatten2DVector implements Iterator<Integer> {

    private List<List<Integer>> list;
    private int x;
    private int y;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.list = vec2d;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Integer next() {
        return list.get(x)
                .get(y++);
    }

    @Override
    public boolean hasNext() {
        while (x < list.size() && y >= list.get(x)
                .size()) {
            ++x;
            y = 0;
        }
        return x < list.size();
    }

    @Override
    public void remove() {
    }
}
