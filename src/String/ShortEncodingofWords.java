package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个字符串数组，进行encoding，使得从每个index开始，直到碰到#，就可以得到一个字符串，例如["time", "me", "bell"]，encoding成下面这种形式:
//        S = "time#bell#" and indexes = [0, 2, 5],求最短的S
//解法描述:主要就是解决两个字符串重叠的情况，把重叠的较短的字符串去除就可以了

public class ShortEncodingofWords {

    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            for (int i = 1; i < w.length(); ++i) {
                s.remove(w.substring(i));
            }
        }

        return s.stream()
                .mapToInt(string -> string.length() + 1)
                .sum();
    }
}
