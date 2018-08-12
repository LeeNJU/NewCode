package Array;

//题目描述:给定m个数组，每个数组升序排列，从不同数组中找到两个数，使得它们的差最大，例如[[1,2,3], [4,5], [1,2,3]]，返回4
//解法描述:要使差最大，找到每个数组的最大值(最后一个元素)和最小值(第一个元素)，但是要确保最小元素和最大元素是来自不同的数组，遍历数组，用start和end表示遍历过的数组中的最小元素和
//        最大元素

public class MaximumDistanceinArrays {

    public int maxDiff(int[][] arrs) {
        int result = 0, start = arrs[0][0], end = arrs[0][arrs[0].length - 1];

        for (int i = 1; i < arrs.length; ++i) {
            // 最大差，这样可以保证不是来组同一个数组
            result = Math.max(result, Math.max(Math.abs(arrs[i][arrs[i].length - 1] - start), Math.abs(end - arrs[i][0])));
            // 更新start和end
            start = Math.min(start, arrs[i][0]);
            end = Math.max(end, arrs[i][arrs[i].length - 1]);
        }
        return result;
    }
}
