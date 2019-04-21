package TwoPointers;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串，只包含小写字母，进行尽可能多的划分，使得每一个字符最多出现在一个partition之中，例如S = "ababcbacadefegdehijhklij"，划分
//       成"ababcbaca", "defegde", "hijhklij"，返回[9,7,8]
//解法描述:记录每个字母最后一次出现的下标，对于每一个partition，记录起始下标partitionStart和终止下标partitionEnd，partitionEnd表示当前partition最远可到达的下标，
//       并且不断更新partitionEnd下标，当i等于partitionEnd的时候，找到了一个partition

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<Integer>();
        int[] lastIndex = new int[26];
        int i = S.length() - 1;
        // 求出每一个元素最后一次出现的index
        while (i >= 0) {
            int index = S.charAt(i) - 'a';
            if (lastIndex[index] == 0) {
                lastIndex[index] = i;
            }

            --i;
        }

        int partitionEnd = -1, partitionStart = 0;
        i = 0;
        while (i < S.length()) {
            partitionEnd = Math.max(partitionEnd, lastIndex[S.charAt(i) - 'a']);

            if (partitionEnd == i) {
                list.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1;
                partitionEnd = -1;
            }

            ++i;
        }

        return list;
    }
}
