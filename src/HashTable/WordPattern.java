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

        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < strs.length; ++i) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(strs[i])) {
                map.put(pattern.charAt(i), strs[i]);
            } else if (!map.containsKey(pattern.charAt(i))) {
                return false;
            } else if (!strs[i].equals(map.get(pattern.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
