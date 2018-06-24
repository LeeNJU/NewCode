package BackTracking;

//题目描述:给定一个二维数组，找到其中最长的递增序列，返回其长度
//解法描述:深搜，注意剪枝，用一个length数组保存当前位置的递增序列的长度，用来剪枝

public class LongestIncreasingPathinaMatrix {

    private int maxLength = 0;

    private void dfs(final int[][] matrix, int i, int j, int[][] length, int cur_length) {
        if (cur_length <= length[i][j]) {
            return;
        }

        length[i][j] = cur_length;
        maxLength = Math.max(maxLength, length[i][j]);

        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            dfs(matrix, i - 1, j, length, cur_length + 1);
        }

        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            dfs(matrix, i, j - 1, length, cur_length + 1);
        }

        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            dfs(matrix, i + 1, j, length, cur_length + 1);
        }

        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            dfs(matrix, i, j + 1, length, cur_length + 1);
        }

    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return maxLength;
        }

        int n = matrix.length, m = matrix[0].length;
        int[][] length = new int[n][m];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dfs(matrix, i, j, length, 1);
            }
        }

        return maxLength;
    }
}
