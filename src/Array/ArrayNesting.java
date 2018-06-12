package Array;

//题目描述:给定一个长度为N的数组，只包含0到N-1，也就是说每个元素是唯一的，从i位置出发，以A[i]为下标，继续遍历，求最大的长度
//解法描述:用一个visited数组，从第一个元素出发，一直遍历并记录长度，如果该元素已经遍历过，那么它的长度必然小于之前遍历的长度，所以略过

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int result = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }

            int count = 0, index = i;
            while (!visited[index]) {
                visited[index] = true;
                index = nums[index];
                ++count;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
