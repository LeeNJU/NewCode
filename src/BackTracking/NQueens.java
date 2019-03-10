package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:求解n皇后问题
//解法描述:递归，在递归的过程中，保存每一列，每一个对角线，反对角线是否被占用

public class NQueens {

    private void dfs(int row, int n, int[] columns, int[] diagonal, int[] principal_diagonal, int[] c, List<List<String>> result) {
        if (row >= n) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                StringBuilder stringBuilder = new StringBuilder(n);
                for (int j = 0; j < n; ++j) {
                    stringBuilder.append(c[i] == j ? "Q" : ".");
                }

                list.add(stringBuilder.toString());
            }

            result.add(list);
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 当前位置可以放
            if (columns[i] == 0 && diagonal[row + i] == 0 && principal_diagonal[n + row - i] == 0) {
                c[row] = i;
                columns[i] = diagonal[row + i] = principal_diagonal[n + row - i] = 1;
                dfs(row + 1, n, columns, diagonal, principal_diagonal, c, result);
                columns[i] = diagonal[row + i] = principal_diagonal[n + row - i] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        // 哪些列被占用
        int[] columns = new int[n];
        // 左下到右上的哪些对角线被占用
        int[] diagonal = new int[2 * n];
        // 左上到右下的哪些对角线被占用
        int[] principal_diagonal = new int[2 * n];
        // 保存每一行皇后的下标
        int[] C = new int[n];

        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, n, columns, diagonal, principal_diagonal, C, result);
        return result;
    }
}
