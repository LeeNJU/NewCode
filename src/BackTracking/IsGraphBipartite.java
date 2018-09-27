package BackTracking;

import java.util.Arrays;

//题目描述:给定一个无向图，判断是不是bipartite
//解法描述:dfs给节点涂色，-1代表未图色(未被访问), 0和1代表两种不同颜色，从每一个节点出发

public class IsGraphBipartite {

    private boolean dfs(int index, int[][] graph, int[] colors, int color) {
        // 当前节点已经被涂色
        if (colors[index] != -1) {
            return colors[index] == color;
        }

        // 只要有一个条路径返回false，结果就是false
        colors[index] = color;
        for (int i = 0; i < graph[index].length; ++i) {
            if (!dfs(graph[index][i], graph, colors, 1 - color)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; ++i) {
            if (colors[i] == -1 && !dfs(i, graph, colors, 1)) {
                return false;
            }
        }

        return true;
    }
}
