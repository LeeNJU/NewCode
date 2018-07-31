package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个图，找到不在环上的所有节点
//解法描述:dfs，表示当前节点的状态，0 表示该节点没有被遍历过，1 表示该节点为安全node，2 表示该节点为不安全node。思路为，
//#A, 初始各个节点状态为0， 当遍历node[i]时，node[i]设为2. 不断DFS node[i]所能够到达的结点。 如果node[i] 能够最终到达安全状态，则设为1.
//#B, 依次遍历各个node做为start point。 DFS时，如果发现当前遍历到的node 为1， 则说明后面继续遍历的话，肯定为安全的status， 直接return true。
//#C, 如果当前node 为2，则说明继续遍历，出现环， return false。

public class FindEventualSafeStates {

    private boolean dfs(int[][] graph, int start, int[] color) {
        if (color[start] != 0) {
            return color[start] == 1;
        }

        // 设置当前节点为访问过的节点，默认当前节点是不安全的节点
        color[start] = 2;
        for (int newNode : graph[start]) {
            if (!dfs(graph, newNode, color)) {
                return false;
            }
        }

        // 只有当前节点的所有子节点都返回true的时候，当前节点才是安全节点
        color[start] = 1;

        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<Integer>();
        if (graph == null || graph.length == 0)
            return result;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (dfs(graph, i, color)) {
                result.add(i);
            }
        }

        return result;
    }
}
