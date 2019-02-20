package BackTracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//题目描述:给定一个非负整数数组，找到所有排列组合的个数，使得每两个相邻的元素的和都是平方数，例如[1,17,8]，返回2，因为有2中满足要求的排列组合[1,8,17] and [17,8,1
//解法描述:统计元素的出现次数，以及哪些元素可以和当前元素形成平方数,然后dfs

public class NumberofSquarefulArrays {

    private int result = 0;
    private Map<Integer, Integer> count = new HashMap<>();
    private Map<Integer, Set<Integer>> squareMap = new HashMap<Integer, Set<Integer>>();

    private void dfs(int num, int left) {
        count.put(num, count.get(num) - 1);

        if (left == 0) {
            ++result;
            count.put(num, count.get(num) + 1);
            return;
        }

        for (int key : squareMap.getOrDefault(num, new HashSet<Integer>())) {
            if (count.get(key) > 0) {
                dfs(key, left - 1);
            }
        }

        count.put(num, count.get(num) + 1);
    }

    public int numSquarefulPerms(int[] A) {
        // 统计出现次数
        Arrays.stream(A)
                .forEach(num -> count.put(num, count.getOrDefault(num, 0) + 1));
        // 对于每个元素，找到可以形成平方数的元素
        for (int key1 : count.keySet()) {
            for (int key2 : count.keySet()) {
                double c = Math.sqrt(key1 + key2);
                if (c == Math.floor(c)) {
                    Set<Integer> set = squareMap.getOrDefault(key1, new HashSet<Integer>());
                    set.add(key2);
                    squareMap.put(key1, set);

                    set = squareMap.getOrDefault(key2, new HashSet<Integer>());
                    set.add(key1);
                    squareMap.put(key2, set);
                }
            }
        }

        for (int key : count.keySet()) {
            dfs(key, A.length - 1);
        }

        return result;
    }
}
