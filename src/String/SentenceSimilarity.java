package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//题目描述:给定两个字符串数组，和一个pairs数组，表示两个字符串相似，判断字符串数组是不是相似的，例如words1 = ["great","acting","skills"] words2 = ["fine","talent","drama"]
//       pairs = [["great","fine"],["drama","acting"],["skills","talent"]],返回true
//解法描述:遍历，用hashmap记录每个字符串的所有相似字符串

public class SentenceSimilarity {

    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
        pairs.stream()
                .forEach(list -> {
                    Set<String> set = map.getOrDefault(list.get(0), new HashSet<String>());
                    set.add(list.get(1));
                    map.put(list.get(0), set);
                });

        int index = 0;
        for (; index < words1.length; ++index) {
            if (words1[index].equals(words2[index])) {
                continue;
            }

            if (!map.getOrDefault(words1[index], new HashSet<String>())
                    .contains(words2[index])
                    && !map.getOrDefault(words2[index], new HashSet<String>())
                            .contains(words1[index])) {
                return false;
            }
        }

        return true;
    }
}
