package Queue;

//题目描述:用一个数组来实现循环队列
//解法描述:head和tail指针，关键在于如何判断队列为空和队列为满的情况，用一个多余的存储空间来帮助判断队列为满的情况

public class ImplementQueuebyCircularArray {

    private int head;
    private int tail;
    private int[] array;

    public ImplementQueuebyCircularArray(int n) {
        this.array = new int[n + 1];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public void enqueue(int element) {
        array[tail] = element;
        tail = ++tail % array.length;
    }

    public int dequeue() {
        int val = array[head];
        head = ++head % array.length;
        return val;
    }
}
