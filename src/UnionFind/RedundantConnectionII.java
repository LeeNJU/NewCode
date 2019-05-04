package UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javafx.util.Pair;

//题目描述:给定n条边，代表n个节点的有向图，有一条边是重复的，找到这条边，使得这条边被删除之后，变成一个树的结构，如果有多个可能的边，返回数组中最后出现的
//解法描述:三种情况，1，节点入度都是1，但是有环，找到形成环的边，2，没有环，有入度为2的节点，3，有环，有入度为2的节点，先找到入度为2的节点，以及指向这个节点的两条边

public class RedundantConnectionII {

    private int root(int[] root, int i) {
        while (i != root[i]) {
            i = root[i];
        }

        return i;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] indegree = new int[edges.length + 1];
        int node = 0;
        // 找到入度为2的节点
        for (int[] edge : edges) {
            ++indegree[edge[1]];
            if (indegree[edge[1]] == 2) {
                node = edge[1];
            }
        }

        int[] root = new int[edges.length + 1];
        IntStream.range(0, root.length)
                .forEach(index -> root[index] = index);

        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
        for (int[] edge : edges) {
            // 对于入度为2的节点的两条边不考虑union find
            if (edge[1] == node) {
                list.add(new Pair<Integer, Integer>(edge[0], edge[1]));
                continue;
            }

            int root1 = root(root, edge[0]);
            int root2 = root(root, edge[1]);
            // 有环，并且环中的节点入度都是1
            if (root1 == root2) {
                return edge;
            }

            root[root1] = root2;
        }

        // 注意这里
        Pair<Integer, Integer> pair = list.get(0);
        return root(root, pair.getKey()) == root(root, pair.getValue()) ? new int[] { pair.getKey(), pair.getValue() }
                : new int[] { list.get(1)
                        .getKey(),
                        list.get(1)
                                .getValue() };
    }
}
