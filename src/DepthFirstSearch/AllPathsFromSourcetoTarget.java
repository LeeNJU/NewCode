package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个图，每个节点的编号为0,1,2...n - 1,找到从0到n - 1的所有路径
//解法描述:dfs

public class AllPathsFromSourcetoTarget {

    private void dfs(int node, int end, int[][] graph, List<Integer> list, List<List<Integer>> result) {
        list.add(node);

        // 注意这里，递归返回的时候要把当前假如的节点从中间结果中删除
        if (node == end) {
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }

        int[] children = graph[node];
        for (int i = 0; i < children.length; ++i) {
            dfs(children[i], end, graph, list, result);
        }

        list.remove(list.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(0, graph.length - 1, graph, new ArrayList<Integer>(), result);
        return result;
    }
}
