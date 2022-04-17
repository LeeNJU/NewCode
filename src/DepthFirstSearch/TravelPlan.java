package DepthFirstSearch;

import java.util.HashSet;

//题目描述:给定一个二维数组表示图, arr[i][j]表示节点i到节点j的cost，从节点0出发，找到cost最小的路径回到节点0
//解法描述:dfs

public class TravelPlan {

  private int minCost = Integer.MAX_VALUE;
  public int travelPlan(int[][] arr) {
    // Write your code here.
    HashSet<Integer> path = new HashSet<>();
    path.add(0);
    for (int i = 1; i < arr.length; ++i) {
      dfs(0, i, path, arr, 0);
    }

    return minCost;
  }

  private void dfs(int prev, int current, HashSet<Integer> path, int[][] arr, int cost) {
    if (current == 0) {
      if (path.size() == arr.length) {
        minCost = Math.min(minCost, cost + arr[prev][current]);
      }
      return;
    }

    if (path.contains(current)) {
      return;
    }

    //访问当前节点
    path.add(current);
    cost += arr[prev][current];

    for (int i = 0; i < arr.length; ++i) {
      dfs(current, i, path, arr, cost);
    }

    path.remove(current);
  }
}
