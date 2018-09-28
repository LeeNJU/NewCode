package BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//题目描述:给定一个起始单词，一个终止单词和一个字典，每次把起始单词变换一个字符，把起始单词变换成终止单词，
//        其中每次变换得到的中间过渡单词必须在字典中能够找到，求最小的变换次数
//解法描述:广度优先遍历，用队列，依次用a到z去代替起始单词的每个元素，判断得到的中间单词是否在字典中，如果在，加入到队列中，其中要注意记录单词的层数

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        Set<String> set = new HashSet<String>();
        wordList.stream()
                .forEach(word -> set.add(word));

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return level;
                }

                char[] strs = str.toCharArray();
                for (int j = 0; j < strs.length; ++j) {
                    char prev = strs[j];
                    for (char a = 'a'; a <= 'z'; ++a) {
                        if (prev == a) {
                            continue;
                        }

                        strs[j] = a;
                        String string = new String(strs);
                        // 从字典中删除
                        if (set.contains(string)) {
                            queue.add(string);
                            set.remove(string);
                        }
                    }

                    strs[j] = prev;
                }
            }

            ++level;
        }

        return 0;
    }
}
