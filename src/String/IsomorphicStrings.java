package String;

import java.util.HashMap;

//题目描述:给定两个字符串，判断他们是不是isomorphic的，例如paper可以被title替换，返回true，egg可以被add替换,返回true
//解法描述:用hashtable保存s到t的映射关系，检查s是不是映射到t，再检查t是不是映射到s

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        // 反过来检查t是不是映射到s，因为可能s中的多个元素映射到t中的同一个元素，所以要检查t是不是映射到s
        map.clear();
        for (int i = 0; i < t.length(); ++i) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), s.charAt(i));
            } else if (map.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
