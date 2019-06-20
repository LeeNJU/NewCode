package Minmax;

import java.util.HashMap;
import java.util.Map;

//题目描述:两个人从[1, maxChoosableInteger]之间轮流选择数字，谁先选择数字使得总数的和超过给定的desiredTotal就是赢，判断第一个选手是否能赢
//解法描述:模拟游戏的策略，保存子问题的解，重点是如何区分子问题的状态，此题的子问题需要用[1, maxChoosableInteger]的数字有没有被选过，以及desiredTotal来描述子问题的状态，
//        其实可以只用[1, maxChoosableInteger]就能描述子问题，因为desiredTotal减去已经选过的元素之和，就得到剩下的元素，用int来表示每个数字是否被选择过

public class CanIWin {

    private boolean dfs(int state, int n, int desiredTotal, Map<Integer, Boolean> map) {
        if (map.containsKey(state)) {
            return map.get(state);
        }

        for (int i = 1; i <= n; ++i) {
            // 当前数字已经被选过
            if ((state >> (i - 1)) % 2 == 1) {
                continue;
            }

            if (i >= desiredTotal || !dfs(state | (1 << (i - 1)), n, desiredTotal - i, map)) {
                map.put(state, true);
                return true;
            }
        }

        map.put(state, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }

        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return dfs(0, maxChoosableInteger, desiredTotal, map);
    }
}
