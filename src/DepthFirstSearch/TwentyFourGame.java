package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//题目描述:给定4个正整数，求能不能算出24，可以加减乘除和括号，例如[4, 1, 8, 7]，返回true因为(8-4) * (7-1) = 24
//解法描述:任选两个数，通过加减乘除得到一个结果，加入到原来的list中，这样就只剩下3个数，然后依次类推进行降维，直到得到1个数，判断是不是等于24

public class TwentyFourGame {

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            double num = list.get(0);
            return Math.abs(num - 24) <= 1e-4;
        }

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                double p1 = list.get(i);
                double p2 = list.get(j);
                List<Double> lists = new ArrayList<Double>();
                // 任意两个数的结果
                lists.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));

                if (Math.abs(p1) > 1e-4) {
                    lists.add(p2 / p1);
                }

                if (Math.abs(p2) > 1e-4) {
                    lists.add(p1 / p2);
                }

                // 注意这里删除下标的顺序
                list.remove(j);
                list.remove(i);

                for (double num : lists) {
                    list.add(num);
                    if (dfs(list)) {
                        return true;
                    }
                    list.remove(num);
                }

                list.add(i, p1);
                list.add(j, p2);
            }
        }

        return false;
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = Arrays.stream(nums)
                .mapToDouble(num -> (double) num)
                .boxed()
                .collect(Collectors.toList());
        return dfs(list);
    }
}
