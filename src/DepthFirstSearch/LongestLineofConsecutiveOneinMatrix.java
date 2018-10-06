package DepthFirstSearch;

//题目描述:给定一个二维数组，只包含0和1，找到连续的1的最大长度，可以是水平，垂直，对角线或者反对角线的方向
//解法描述:遍历，对于每个点，统计不同方向的长度

public class LongestLineofConsecutiveOneinMatrix {

    public int longestLine(int[][] M) {
        int result = 0;
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                if (M[i][j] == 0) {
                    continue;
                }

                int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
                int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };
                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    int count = 1;

                    while (x < M.length && x >= 0 && y >= 0 && y < M[0].length && M[x][y] == 1) {
                        x += dx[k];
                        y += dy[k];
                        ++count;
                    }

                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }
}
