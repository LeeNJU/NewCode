package String;

import java.util.Arrays;

//题目描述:给定两个字符串s1和s2，判断s2的某个子字符串是s1的permutation，例如s1 = "ab" s2 = "eidbaooo"，返回true因为s2包含"ba"是"ab"的某个permutation
//解法描述:记录s1中字符的出现次数，关键是判断子字符串，维持一个大小为s1.length()的窗口，遍历s2，每次加入一个元素，把次数减1，每次从窗口弹出元素，把次数加1，然后
//        检查窗口中的元素的出现次数是不是全部为0，如果是0，代表当前窗口包含的元素就是一个permutation

public class PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            ++count[c - 'a'];
        }

        for (int j = 0, i = 0; i < s2.length(); ++i) {
            --count[s2.charAt(i) - 'a'];
            if (i < s1.length() - 1) {
                continue;
            }

            if (i - j + 1 > s1.length()) {
                ++count[s2.charAt(j++) - 'a'];
            }

            if (Arrays.stream(count)
                    .allMatch(num -> num == 0)) {
                return true;
            }
        }

        return false;
    }
}
