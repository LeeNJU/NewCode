package BreadthFirstSearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//题目描述:给定一个字符串表示基因，每次可以把一个基因变成另一个基因，求最少需要多少步把一个字符串基因变成另一个字符串基因，例如start:"AACCGGTT", end:"AACCGGTA",
//        bank:["AACCGGTA"],只需要一步就可以把start字符串变成end字符串，变换过程中的字符串必须在bank中
//解法描述:广搜，类似于word ladder

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<String>();
        Arrays.stream(bank)
                .forEach(word -> set.add(word));

        char[] mutations = { 'A', 'C', 'G', 'T' };
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                if (word.equals(end)) {
                    return level;
                }

                char[] words = word.toCharArray();
                for (int j = 0; j < words.length; ++j) {
                    char prev = word.charAt(j);
                    for (int k = 0; k < mutations.length; ++k) {
                        if (mutations[k] != prev) {
                            words[j] = mutations[k];
                            String str = new String(words);
                            if (set.contains(str)) {
                                set.remove(str);
                                queue.add(str);
                            }
                        }
                    }

                    words[j] = prev;
                }
            }

            ++level;
        }

        return -1;
    }
}
