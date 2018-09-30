package String;

import java.util.List;

//题目描述:给定一个字符串数组和两个字符串，找到这两个字符串在数组中的最近距离，数组中有重复元素，例如
//        ["practice", "makes", "perfect", "coding", "makes"],"makes"和"coding"的最近距离是1
//解法描述:扫一遍，记录word的下标，同时记录最短距离
public class ShortestWordDistance {

    int shortestDistance(List<String> words, String word1, String word2) {
        int index1 = -1, index2 = -1, result = Integer.MAX_VALUE;
        for (int i = 0; i < words.size(); ++i) {
            if (words.get(i)
                    .equals(word1)) {
                index1 = i;
            } else if (words.get(i)
                    .equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }

    // version3
    // 题目描述:跟第一题一样，只是word1和word2可能是一样的
    // 解法描述:跟第一题解法类似，不过要判断下标是否相等
    int shortestDistance3(List<String> words, String word1, String word2) {
        int min_distance = Integer.MAX_VALUE, index1 = -1, index2 = -1;

        for (int i = 0; i < words.size(); ++i) {
            if (words.get(i)
                    .equals(word1)) {
                index1 = i;
                if (index2 != -1)
                    min_distance = (index1 == index2 ? min_distance : Math.min(Math.abs(index1 - index2), min_distance));
            }

            if (words.get(i)
                    .equals(word2)) {
                index2 = i;
                if (index1 != -1)
                    min_distance = (index1 == index2 ? min_distance : Math.min(Math.abs(index1 - index2), min_distance));
            }
        }

        return min_distance;
    }
}
