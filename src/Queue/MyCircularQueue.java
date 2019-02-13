package Queue;

//题目描述:用一个数组来实现循环队列
//解法描述:head和tail指针，关键在于如何判断队列为空和队列为满的情况，用一个多余的存储空间来帮助判断队列为满的情况

public class MyCircularQueue {

    private int head;
    private int tail;
    private int[] array;

    public MyCircularQueue(int k) {
        array = new int[k + 1];
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        array[tail] = value;
        tail = ++tail % array.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = ++head % array.length;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : array[head];
    }

    // 注意这里对下标的处理
    public int Rear() {
        return isEmpty() ? -1 : array[(tail - 1 + array.length) % array.length];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }
}
