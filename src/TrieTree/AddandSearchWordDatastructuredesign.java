package TrieTree;

import java.util.Arrays;
import java.util.Objects;

import Util.TrieNode;

//题目描述:定义一个数据结构，可以对字符串进行添加和搜索，支持正则匹配搜索，碰到'.'表示任意字符
//解法描述:用trie tree,添加操作和trie tree一样，在搜索的时候，如果碰到'.'就进行递归搜索，没有碰到'.'就进行正常搜索

public class AddandSearchWordDatastructuredesign {

    private TrieNode root;

    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    private boolean search(final String word, int index, TrieNode root) {
        if (root == null) {
            return false;
        }

        // 要看当前节点是不是字符串的结尾
        if (index >= word.length()) {
            return root.isWord;
        }

        TrieNode cur = root;
        for (int i = index; i < word.length(); ++i) {
            // 碰到'.',就用递归的方式进行搜索
            if (word.charAt(i) == '.') {
                int pos = i + 1;
                // 对每一个非null的节点进行递归搜索
                return Arrays.stream(cur.children)
                        .filter(Objects::nonNull)
                        .anyMatch(node -> search(word, pos, node));
                // 如果不是'.',就按照正常的方式进行搜索
            } else {
                int pos = word.charAt(i) - 'a';
                if (cur.children[pos] == null) {
                    return false;
                } else {
                    cur = cur.children[pos];
                }
            }
        }

        return cur.isWord;
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }

        // 最后要把字符串设为结尾
        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}
