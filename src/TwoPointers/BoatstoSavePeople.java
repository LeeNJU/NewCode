package TwoPointers;

import java.util.Arrays;

//题目描述:给定一个数组，代表人的体重，还有一个船的最大载重量，每条船最多装2个人，求最少需要几条船装所有人
//解法描述:按重量排序，双指针指向最左边的人和最右边的人

public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int right = people.length - 1, left = 0;
        while (left <= right) {
            // 左边的人如果装得下就装
            if (people[left] + people[right] <= limit) {
                ++left;
            }

            // 右边的人一定装得下
            --right;
            ++count;
        }

        return count;
    }
}
