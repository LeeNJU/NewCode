package BackTracking;

import java.util.List;

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
}
