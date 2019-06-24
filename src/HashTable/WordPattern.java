package HashTable;

import java.util.HashMap;

//题目描述:给定两个字符串，判断pattern是不是一样的，例如pattern = "abba", str = "dog cat cat dog" should return true.
//解法描述:用hashmap保存字符和字符串之间的映射关系，注意这里要保持字符和字符串的双向映射

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < strs.length; ++i) {
            char c = pattern.charAt(i);
            if (!map1.getOrDefault(c, strs[i])
                    .equals(strs[i])
                    || !map2.getOrDefault(strs[i], c)
                            .equals(c)) {
                return false;
            }

            map1.put(c, strs[i]);
            map2.put(strs[i], c);
        }

        return true;
    }
}
