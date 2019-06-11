package HashTable;

import Util.CacheNode;

//题目描述:实现一个hashmap
//解法描述:用链表解决冲突，构造一个数组，每一个位置放一个dummy节点，先根据hash function产生index，判断该位置上是否有元素，Node是一个list，可以遍历

public class DesignHashMap {

    private CacheNode[] list;

    public DesignHashMap() {
        list = new CacheNode[10000];
    }

    // hash function
    private int getIndex(final int key) {
        return Integer.hashCode(key) % list.length;
    }

    // 当同一个index出现冲突的时候，遍历链表，判断key是否存在，注意这里返回的是prev节点
    private CacheNode find(CacheNode node, final int key) {
        CacheNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        // 添加dummy节点
        if (list[index] == null) {
            list[index] = new CacheNode(-1, -1);
        }

        CacheNode node = find(list[index], key);
        if (node.next == null) {
            node.next = new CacheNode(key, value);
        } else {
            node.next.value = value;
        }
    }

    public int get(int key) {
        final int index = getIndex(key);
        if (list[index] == null) {
            return -1;
        }

        CacheNode node = find(list[index], key);
        return node.next == null ? -1 : node.next.value;
    }

    public void remove(int key) {
        final int index = getIndex(key);
        if (list[index] == null) {
            return;
        }

        CacheNode node = find(list[index], key);
        if (node.next != null) {
            node.next = node.next.next;
        }
    }
}
