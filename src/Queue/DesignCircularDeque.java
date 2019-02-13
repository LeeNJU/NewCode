package Queue;

//题目描述:实现一个deque
//解法描述:和Queue不太一样，可以在开头和结尾插入元素

public class DesignCircularDeque {

    private int head;
    private int tail;
    private int[] array;

    // 注意这里初始化head和tail
    public DesignCircularDeque(int k) {
        array = new int[k + 1];
        head = k;
        tail = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        array[head] = value;
        head = (--head + array.length) % array.length;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        array[tail] = value;
        tail = ++tail % array.length;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = ++head % array.length;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail - 1 + array.length) % array.length;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : array[(head + 1) % array.length];
    }

    public int getRear() {
        return isEmpty() ? -1 : array[(tail - 1 + array.length) % array.length];
    }

    public boolean isEmpty() {
        return (head + 1) % array.length == tail;
    }

    public boolean isFull() {
        return tail == head;
    }
}
