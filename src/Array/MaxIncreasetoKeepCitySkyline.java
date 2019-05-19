package Array;

//题目描述:给定一个二维数组表示房屋高度，可以得到四个方向看的sky line，现在可以增加building的高度，但是不能影响sky line，求最少可以增加的高度之和
//解法描述:对于每个元素，找到该行和该列的sky line元素，取最小值，这就是最大高度

public class MaxIncreasetoKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] column = new int[grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; ++j) {
                max = Math.max(max, grid[i][j]);
            }

            row[i] = max;
        }

        for (int i = 0; i < grid[0].length; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; ++j) {
                max = Math.max(max, grid[j][i]);
            }

            column[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                sum += Math.min(row[i], column[j]) - grid[i][j];
            }
        }

        return sum;
    }
}
