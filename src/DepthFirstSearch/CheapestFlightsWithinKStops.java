package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

//题目描述:给定n个节点，代表城市，一个节点到另一个节点有cost，给定初始节点和终止节点，最多停留k步，找到最小cost的路径
//解法描述:dfs会超时

public class CheapestFlightsWithinKStops {

    private int cost = Integer.MAX_VALUE;

    private void dfs(int node, int dst, boolean[] visited, int curCost, int k, Map<Integer, List<Pair<Integer, Integer>>> graph) {
        if (visited[node] || k < 1) {
            return;
        }

        if (node == dst) {
            cost = Math.min(cost, curCost);
            return;
        }

        visited[node] = true;

        graph.getOrDefault(node, new ArrayList<Pair<Integer, Integer>>())
                .stream()
                .forEach(pair -> {
                    dfs(pair.getKey(), dst, visited, curCost + pair.getValue(), k - 1, graph);
                });

        visited[node] = false;

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        for (int i = 0; i < flights.length; ++i) {
            List<Pair<Integer, Integer>> list = graph.getOrDefault(flights[i][0], new ArrayList<Pair<Integer, Integer>>());
            list.add(new Pair<Integer, Integer>(flights[i][1], flights[i][2]));
            graph.put(flights[i][0], list);
        }

        dfs(src, dst, visited, 0, K, graph);

        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
}
