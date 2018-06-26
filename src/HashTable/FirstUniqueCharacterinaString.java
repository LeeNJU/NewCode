package HashTable;

import java.util.HashMap;

//题目描述:给定一个字符串，找到第一个出现的唯一的字符，返回下表
//解法描述:hashtable存每个字符出现的次数，然后找到第一个unique的字符

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0));
        }

        for (int i = 0; i < s.length(); ++i) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
