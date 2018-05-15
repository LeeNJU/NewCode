package Array;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个矩阵，按照螺旋顺序转换成一维数组
//解法描述:用两个坐标记录左上角和右下角，用来判断边界，循环结束条件为行数或列数小于1，每个while循环中，用4个for循环处理每一行每一列,注意x1与x2相等，y1与y2相等的情况，
//        即array = {{2,3}}，或array = {{2}， {3}}

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length, n = matrix[0].length;
        int x1 = 0, y1 = 0, x2 = m - 1, y2 = n - 1;

        // 结果集的大小必须等于m * n
        while (result.size() < m * n) {
            // 处理上面一行
            for (int i = y1; i <= y2; ++i) {
                result.add(matrix[x1][i]);
            }

            // 处理右边一列
            for (int i = x1 + 1; i <= x2; ++i) {
                result.add(matrix[i][y2]);
            }

            // 判断x2是否和x1相等，即array = {{2,3}}
            if (x2 > x1) {
                // 处理下面一行
                for (int i = y2 - 1; i >= y1; --i) {
                    result.add(matrix[x2][i]);
                }
            }

            // 判断y1与y2是否相等，即array = {{2}， {3}}
            if (y2 > y1) {
                // 处理左边一列
                for (int i = x2 - 1; i > x1; --i) {
                    result.add(matrix[i][y1]);
                }
            }

            ++x1;
            ++y1;
            --x2;
            --y2;
        }

        return result;
    }
}
