package DynamicProgrammimg;

//题目描述:给定n个柱子和k种颜色，给柱子涂色，最多相邻的两个柱子颜色相同，求总共有多少种涂色方法
//解法描述:dp,用两种状态表示当前颜色的涂法，与之前颜色相同，与之前颜色不同
public class PaintFence {

    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int sameColor = k, diffColor = k * (k - 1);
        for (int i = 3; i <= n; ++i) {
            int a = diffColor;
            int b = (sameColor + diffColor) * (k - 1);

            sameColor = a;
            diffColor = b;
        }

        return sameColor + diffColor;
    }
}
