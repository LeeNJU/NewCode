package Array;

import java.util.Iterator;
//题目描述:peeking iterator
//解法描述:next永远指向下一个元素，每次调用next()都把值赋给next

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = iterator.hasNext() ? iterator.next() : null;
    }

    public Integer peek() {
        return this.next;
    }

    @Override
    public Integer next() {
        Integer res = this.next;
        this.next = this.iterator.hasNext() ? this.iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }
}
