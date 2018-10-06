package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//题目描述:给定一个字符串数组，里面的字符串按照一定顺序排列，找到这些字符串的相对顺序，例如["wrt","wrf","er",
//        "ett","rftt"]，那么字符的相对顺序是"wertf"
//解法描述:本质其实就是图，字符之间的相对顺序就是一条有向边，先构造一个图，然后用广搜判断是否有环

public class AlienDictionary {

    private void build(Map<Character, List<Character>> graph, Map<Character, Integer> inDegree, String[] words) {
        // 初始化图和入度
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<Character>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // 统计入度和边
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index);
                if (c1 != c2) {
                    graph.get(c1)
                            .add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
                index++;
            }
        }
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        Map<Character, Integer> inDegree = new HashMap<Character, Integer>();
        build(graph, inDegree, words);

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) { // Build queue with item of inDegree==0: means no edge points towards it.
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char edgeNode : graph.get(c)) { // reduce edge degrees count since node:graph.get(c) has been processed
                inDegree.put(edgeNode, inDegree.get(edgeNode) - 1);
                if (inDegree.get(edgeNode) == 0) {
                    queue.add(edgeNode);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
