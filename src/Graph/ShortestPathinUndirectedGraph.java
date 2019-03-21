package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import Util.UndirectedGraphNode;

//题目描述:给定一个无向图，和两个节点，找到这两个节点之间的最短距离
//解法描述:bfs

public class ShortestPathinUndirectedGraph {

    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        Set<Integer> visited = new HashSet<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        visited.add(A.label);
        queue.add(A);

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                UndirectedGraphNode undirectedGraphNode = queue.poll();
                if (undirectedGraphNode.label == B.label) {
                    return distance;
                }

                undirectedGraphNode.neighbors.stream()
                        .filter(node -> !visited.contains(node))
                        .forEach(node -> {
                            queue.add(node);
                            visited.add(node.label);
                        });
            }

            ++distance;
        }

        return distance;
    }
}
