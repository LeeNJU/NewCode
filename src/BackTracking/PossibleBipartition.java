package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:和is bipartite一模一样
//解法描述:
public class PossibleBipartition {

    private boolean dfs(int n, Map<Integer, List<Integer>> graph, int[] visited, int color) {
        if (visited[n] != -1) {
            return visited[n] == color;
        }

        visited[n] = color;
        List<Integer> list = graph.getOrDefault(n, new ArrayList<Integer>());
        for (int i = 0; i < list.size(); ++i) {
            if (!dfs(list.get(i), graph, visited, 1 - color)) {
                return false;
            }
        }

        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < dislikes.length; ++i) {
            List<Integer> list = graph.getOrDefault(dislikes[i][0], new ArrayList<>());
            list.add(dislikes[i][1]);
            graph.put(dislikes[i][0], list);

            list = graph.getOrDefault(dislikes[i][1], new ArrayList<>());
            list.add(dislikes[i][0]);
            graph.put(dislikes[i][1], list);
        }

        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        for (int i = 1; i <= N; ++i) {
            if (visited[i] == -1 && !dfs(i, graph, visited, 1)) {
                return false;
            }
        }

        return true;
    }

}
