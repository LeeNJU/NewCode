package HashTable;

import java.util.HashSet;

//题目描述:给定两个字符串J和S，找到S中多少个元素出现在J中，例如J = "aA", S = "aAAbbbb"，返回3
//解法描述:hashtable

public class JewelsandStones {

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); ++i) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (set.contains(S.charAt(i))) {
                ++count;
            }
        }

        return count;
    }
}
