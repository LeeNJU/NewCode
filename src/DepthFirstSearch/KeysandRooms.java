package DepthFirstSearch;

import java.util.HashSet;
import java.util.List;

//题目描述:给定n个点的图，从0出发，判断能不能遍历所有的节点
//解法描述:dfs

public class KeysandRooms {

    private void dfs(int index, List<List<Integer>> rooms, HashSet<Integer> visited) {
        if (visited.contains(index)) {
            return;
        }

        visited.add(index);
        rooms.get(index)
                .stream()
                .forEach(num -> dfs(num, rooms, visited));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<Integer>();
        dfs(0, rooms, set);
        return set.size() == rooms.size();
    }
}
