package TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

//题目描述:给定一个值n和一些边，以每一个节点都可以形成一棵树，要求找到所有的点，使得以这些点为根节点的树的高度最小。
//解法描述:类似于拓扑排序，先删除叶子节点，入度减1，继续删除叶子节点，直到节点的个数小于等于2

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for (int[] edge : edges) {
            indegree.put(edge[0], indegree.getOrDefault(edge[0], 0) + 1);
            indegree.put(edge[1], indegree.getOrDefault(edge[1], 0) + 1);

            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<Integer>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<Integer>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        indegree.keySet()
                .stream()
                .filter(num -> indegree.get(num) == 1)
                .forEach(num -> queue.add(num));

        while (n > 2) {
            // 注意这里，只能一层一层的删除节点，不能用while循环，while循环会把所有节点加到队列中
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int num = queue.poll();
                --n;

                graph.get(num)
                        .stream()
                        .forEach(val -> {
                            indegree.put(val, indegree.get(val) - 1);
                            if (indegree.get(val) == 1) {
                                queue.add(val);
                            }
                        });
            }
        }

        return queue.stream()
                .collect(Collectors.toList());
    }
}
