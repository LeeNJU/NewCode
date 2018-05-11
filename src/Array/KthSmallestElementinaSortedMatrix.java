package Array;

//题目描述:给定一个二维数组，每行每列都已经排好序，要求第k个最小的元素
//解法描述:用一个数组保存当前每一列最小元素的下标，遍历这个一维数组，找到最小的元素，然后下标加1，可以用堆来
//        优化查找最小元素的时间。

public class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int[] index = new int[matrix.length];

        int result = 0;
        while (k > 0) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < index.length; ++i) {
                if (index[i] < matrix[i].length && matrix[i][index[i]] < minVal) {
                    minVal = matrix[i][index[i]];
                    minIndex = i;
                }
            }

            ++index[minIndex];
            --k;
            result = minVal;
        }

        return result;
    }

    // public int kthSmallest(int[][] matrix, int k) {
    // int n = matrix.length;
    // PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    // for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
    // for(int i = 0; i < k-1; i++) {
    // Tuple t = pq.poll();
    // if(t.x == n-1) continue;
    // pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
    // }
    // return pq.poll().val;
    // }
}
