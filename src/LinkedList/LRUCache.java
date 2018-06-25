package LinkedList;

import java.util.HashMap;

import Util.CacheNode;

//题目描述:实现一个LRU cache算法，即Least Recently Used算法，最近没有被访问到的数据，之后被访问到的可能性
//         就很低
//解法描述:CacheNode表示一个节点，包括key和value，用双向链表表示cache，一个hashtable表示每一个key到list中
//        的元素，刚刚访问的元素放到链表前面，最后一个元素就是最不经常使用的元素

public class LRUCache {

    private HashMap<Integer, CacheNode> hashMap;
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);
    private int capacity;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<Integer, CacheNode>();
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        CacheNode node = hashMap.get(key);
        deleteNode(node);
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            CacheNode node = hashMap.get(key);
            node.value = value;

            deleteNode(node);
            moveToHead(node);
            return;
        }

        if (hashMap.size() == this.capacity) {
            hashMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        CacheNode node = new CacheNode(key, value);
        hashMap.put(key, node);
        moveToHead(node);
    }

    private void moveToHead(CacheNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
