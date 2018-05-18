package String;

import java.util.HashSet;
import java.util.Set;

//题目描述：给定一个字符串，找出其中最大的没有重复字符的子串的长度。"abcabcbb"的是abc,长度为3，"bbbbb"的是b，长度为1
//解法描述：用两个指针，分别指向当前子串，相当于窗口，遍历字符串，并检查在[i,j]区间里是否有重复元素

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int result = 0;
        Set<Character> set = new HashSet<Character>();

        for (; j < s.length(); ++j) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
            } else {
                while (i <= j && s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    ++i;
                }
                ++i;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
