package TrieTree;

import Util.TrieNode;

//题目描述：实现前缀树
//解法描述：(个人理解)边用来存储字符，每一个节点有26个指针，指向不同的子节点，nullptr表示子节点不存在

public class ImplementTrie {

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }

            cur = cur.children[index];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }

            cur = cur.children[index];
        }

        return true;
    }
}
