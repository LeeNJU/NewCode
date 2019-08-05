package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个数字n，找到所有因数的组合，例如n = 12，返回[ [2, 6], [2, 2, 3], [3, 4]]
//解法描述:递归，每一次加入一个数字，确保加入的数字大于等于已经加入的数字

public class FactorCombinations {

    private void dfs(int n, int index, List<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }

        for (int i = index; i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
                dfs(n / i, index, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(n, 2, new ArrayList<>(), result);
        return result;
    }
}
