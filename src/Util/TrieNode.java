package Util;

public class TrieNode {

    public TrieNode[] children;
    public boolean isWord = false;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
