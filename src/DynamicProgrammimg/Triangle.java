package DynamicProgrammimg;

//题目描述:给定一个三角形的二维数组，找到一个路径，使得和最小，例如
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//       最小路径是2 + 3 + 5 + 1 = 11，返回11
//解法描述:dp,反向

public class Triangle {

    public int minimumTotal(int[][] triangle) {
        int n = triangle.length, m = triangle[n - 1].length;

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < triangle[i].length; ++j) {
                triangle[i][j] = Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j];
            }
        }

        return triangle[0][0];
    }
}
