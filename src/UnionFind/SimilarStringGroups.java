package UnionFind;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个字符串数组，可能包含重复字符串，两个字符串是相似的如果只有2个字符是不同的，现在把相似的字符串分成一组，求总共有多少组，
//        例如["tars","rats","arts","star"]，总共有2组，{"tars", "rats", "arts"} and {"star"}
//解法描述:union find,扫描每个字符串，对于当前字符串A[i],寻找有没有相似的字符串A[j]，然后把A[i]合并到A[j]的group中,最后扫描map，如果key和value相等，表示这是一个root
//        root的个数就是group的个数

public class SimilarStringGroups {

    private String find(String s, Map<String, String> map) {
        while (!map.getOrDefault(s, s)
                .equals(s)) {
            s = map.get(s);
        }

        return s;
    }

    private boolean isSimilar(final String s1, final String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diff;
            }
        }

        return diff == 2;
    }

    public int numSimilarGroups(String[] A) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < A.length; ++i) {
            // 重复元素，之前已经考虑过
            if (map.containsKey(A[i])) {
                continue;
            }

            map.put(A[i], A[i]);
            for (int j = 0; j < i; ++j) {
                if (isSimilar(A[i], A[j])) {
                    String root = find(A[j], map);
                    map.put(root, A[i]);
                }
            }
        }

        // key和value相等就是root，root的个数就是group的个数
        return (int) map.keySet()
                .stream()
                .filter(key -> map.get(key)
                        .equals(key))
                .count();
    }
}
