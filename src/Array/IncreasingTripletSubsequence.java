package Array;

//题目描述:给定一个未排序的数组，判断是否存在一个长度为3递增的子序列，例如
//         num[i] < num[j] < num[k]并且i < j < k
//解法描述:遍历数组，保存第一个最小值和倒数第二小的值，如果当前元素比最小值和倒数第二小的值都大，说明此时有1
//        个递增的长度为3的子序列了，返回true

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        // 注意此题要保持最小元素和第二小元素的顺序
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (m1 >= num) {
                m1 = num;
            } else if (m2 >= num) {
                m2 = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
