package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:给定n个节点，每个节点拥有钱和quietness，对于每个节点，找到钱大于等于当前节点，并且quiteness最小的节点
//解法描述:根据钱的大小关系建立图，对于每个节点进行dfs，找到quietness最小的节点

public class LoudandRich {

    // 对于i节点，返回满足条件的节点序号
    private int dfs(int i, int[] quiet, int[] result, Map<Integer, List<Integer>> map) {
        // memoization
        if (result[i] >= 0) {
            return result[i];
        }

        result[i] = i;
        for (int j : map.getOrDefault(i, new ArrayList<Integer>())) {
            int node = dfs(j, quiet, result, map);
            if (quiet[result[i]] > quiet[node]) {
                result[i] = node;
            }
        }

        return result[i];
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < richer.length; ++i) {
            List<Integer> list = map.getOrDefault(richer[i][1], new ArrayList<Integer>());
            list.add(richer[i][0]);
            map.put(richer[i][1], list);
        }

        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < result.length; ++i) {
            result[i] = dfs(i, quiet, result, map);
        }

        return result;
    }
}
