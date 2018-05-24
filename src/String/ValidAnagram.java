package String;

import java.util.Arrays;

//题目描述:给定两个字符串s和t，判断它们是不是anagram，
//解法描述:先排序，然后在比较

public class ValidAnagram {

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }
}
