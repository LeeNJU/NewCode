package Util;

public class CacheNode {
    public int key;
    public int value;
    public CacheNode prev;
    public CacheNode next;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
