package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//题目描述:给定一个值n和一些边，以每一个节点都可以形成一棵树，要求找到所有的点，使得以这些点为根节点的树的高度最小。
//解法描述:类似于拓扑排序，找到入度为1的叶子节点，先删除叶子节点，入度减1，继续删除叶子节点，直到节点的个数小于等于2
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }

        int[] indegree = new int[n];

        // 统计入度
        for (int i = 0; i < edges.length; ++i) {
            ++indegree[edges[i][0]];
            ++indegree[edges[i][1]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;
            // 注意这里，只能一层一层的删除节点，不能用while循环，while循环会把所有节点加到队列中
            for (int i = 0; i < size; ++i) {
                int node = queue.poll();
                for (int j = 0; j < edges.length; ++j) {
                    if (node == edges[j][0]) {
                        --indegree[edges[j][1]];
                        if (indegree[edges[j][1]] == 1) {
                            queue.add(edges[j][1]);
                        }
                    }

                    if (node == edges[j][1]) {
                        --indegree[edges[j][0]];
                        if (indegree[edges[j][0]] == 1) {
                            queue.add(edges[j][0]);
                        }
                    }
                }
            }
        }

        return queue.stream()
                .collect(Collectors.toList());
    }
}
