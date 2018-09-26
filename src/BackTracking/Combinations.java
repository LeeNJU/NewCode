package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个值n和k，n表示1到n个数字，求出1到n中大小为k的组合，例如n = 4 and k = 2, 解为[[2, 4],[3, 4],[2, 3],[1, 2],[1, 3],[1, 4]]
//解法描述:递归

public class Combinations {

    private void dfs(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; ++i) {
            list.add(i);
            dfs(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(n, k, 1, new ArrayList<Integer>(), result);

        return result;
    }
}
