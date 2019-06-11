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
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (!map.containsKey(s.charAt(i)) || !map.containsValue(t.charAt(i)) || map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
