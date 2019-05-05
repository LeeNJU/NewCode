package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import Util.DirectedGraphNode;

//题目描述:给定一个有向图和两个顶点，判断这个两个顶点是不是相连的
//解法描述:dfs或者bfs

public class RouteBetweenTwoNodesinGraph {

    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        HashSet<DirectedGraphNode> visited = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            if (node == t) {
                return true;
            }

            node.neighbors.stream()
                    .filter(directedGraphNode -> !visited.contains(directedGraphNode))
                    .forEach(directedGraphNode -> {
                        queue.add(directedGraphNode);
                        visited.add(directedGraphNode);
                    });
        }

        return false;
    }
}
