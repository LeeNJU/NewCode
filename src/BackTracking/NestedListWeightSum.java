package BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.NestedInteger;

//题目描述:给定一个嵌套的链表，求出元素的和，例如[1,[4,[6]]]返回27，因为1的深度是1,4的深度是2,6的深度是3，所以和是1 * 1 + 2 * 4 + 6 * 3 = 27.
//解法描述:递归，判断当前元素是否是一个整数还是一个链表，然后根据深度求和

public class NestedListWeightSum {

    private int dfs(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); ++i) {
            if (nestedList.get(i)
                    .isInteger()) {
                sum += nestedList.get(i)
                        .getInteger() * level;
            } else {
                sum += dfs(nestedList.get(i)
                        .getList(), level + 1);
            }
        }

        return sum;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    // 版本2:深度反过来，[1,[4,[6]]]，返回17，因为1 * 3 + 4 * 2 + 6 * 1 = 17
    // bfs，weightedSum和unweightedSum，遍历一层就把元素加到unweightedSum，再加入到weightedSum，这样就可以重复加

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weighted = 0, unweighted = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        nestedList.stream()
                .forEach(queue::add);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    unweighted += nestedInteger.getInteger();
                } else {
                    nestedInteger.getList()
                            .stream()
                            .forEach(queue::add);
                }
            }

            weighted += unweighted;
        }

        return weighted;
    }
}
