package Graph;

import java.util.HashMap;
import java.util.Map;

import Util.UndirectedGraphNode;

//题目描述:clone一个图
//解法描述:dfs

public class CloneGraph {

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(node.label);
        map.put(node.label, undirectedGraphNode);
        for (UndirectedGraphNode child : node.neighbors) {
            undirectedGraphNode.neighbors.add(dfs(child, map));
        }

        return undirectedGraphNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return dfs(node, map);
    }
}
