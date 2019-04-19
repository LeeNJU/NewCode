package String;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//题目描述:给定两个字符串数组，A和B，找到A中所有的字符串a，使得B中的所有字符串都是a的子集，例如A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
//        "facebook",B中所有字符串都是"facebook"的子集，所谓子集就是每个字符的出现次数都小于另一个字符串
//解法描述:暴力解，对于B中的每个字符串统计字符的出现次数，在统计每个字符的最大出现次数，然后A中的字符串只要比每个字符的最大出现次数多，就可以保证所有字符串是子集

public class WordSubsets {

    private boolean match(final String word, int[] maxFrequency) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            ++count[c - 'a'];
        }

        return IntStream.range(0, count.length)
                .allMatch(index -> count[index] >= maxFrequency[index]);
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        // B中每个字符对应的最大出现次数
        int[] maxFrequency = new int[26];
        int[][] frequency = new int[B.length][26];
        for (int i = 0; i < B.length; ++i) {
            for (char c : B[i].toCharArray()) {
                ++frequency[i][c - 'a'];
                maxFrequency[c - 'a'] = Math.max(maxFrequency[c - 'a'], frequency[i][c - 'a']);
            }
        }

        return Arrays.stream(A)
                .filter(word -> match(word, maxFrequency))
                .collect(Collectors.toList());
    }
}
