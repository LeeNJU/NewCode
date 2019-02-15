package Array;

//题目描述:给定一个整数数组，把数组划分成两个连续的数组，使得左边数组的元素总是小于等于右边的数组元素，返回最小的左边数组的大小,例如[5,0,3,8,6]，划分成left = [5,0,3],
//        right = [8,6]
//解法描述:max表示下标0到i的最大值，localMax表示最近一个解的最大值，localMax小于当前元素时，必须要把当前元素放到左边数组中

public class PartitionArrayintoDisjointIntervals {

    public int partitionDisjoint(int[] A) {
        int localMax = A[0], max = A[0], index = 0;

        for (int i = 0; i < A.length; ++i) {
            if (localMax > A[i]) {
                localMax = max;
                index = i;
            } else {
                max = Math.max(max, A[i]);
            }
        }

        return index + 1;
    }
}
