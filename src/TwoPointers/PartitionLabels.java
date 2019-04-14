package TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//题目描述:给定一个字符串，只包含小写字母，进行尽可能多的划分，使得每一个字符最多出现在一个partition之中，例如S = "ababcbacadefegdehijhklij"，划分
//       成"ababcbaca", "defegde", "hijhklij"，返回[9,7,8]
//解法描述:记录每个字母的出现次数，遍历字符串，hashset表示当前partition中还没有遍历完的字母

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<Integer>();
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            ++count[c - 'a'];
        }

        HashSet<Character> set = new HashSet<Character>();
        int start = 0;
        for (int i = 0; i < S.length(); ++i) {
            // 当前字母不是最后一次出现，后面还会出现，说明当前partition不能cover这个字母
            if (--count[S.charAt(i) - 'a'] != 0) {
                set.add(S.charAt(i));
                continue;
            }

            // 当前字母已经遍历完了，从hashset中删除，如果hashset为空，表示当前partition中的字母只在当前partition中出现，找到了一个partition
            set.remove(S.charAt(i));
            if (set.isEmpty()) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }

        return list;
    }
}
