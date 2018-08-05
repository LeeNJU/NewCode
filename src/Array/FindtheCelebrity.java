package Array;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定n个人，分别用0,1,2...n-1表示，celebrity的定义是，所有人都认识他，但是他不认识其他人，判断这n个
//        人里面是否有celebrity，如果没有返回-1，如果有返回对应的label
//解法描述:每次选两个人a和b,如果a认识b，那么a肯定不是celebrity，如果a不认识b,那么b肯定不是celebrity，最后只
//         剩一个人，判这个人是不是celebrity

public class FindtheCelebrity {
    private boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            nums.add(i);
        }

        while (nums.size() > 1) {
            int num2 = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);
            int num1 = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);

            if (knows(num1, num2)) {
                nums.add(num2);
            } else {
                nums.add(num1);
            }
        }

        int result = nums.get(0);
        for (int i = 0; i < n; ++i) {
            if (result == i) {
                continue;
            }

            if (knows(result, i) || !knows(i, result)) {
                return -1;
            }
        }

        return result;
    }
}
