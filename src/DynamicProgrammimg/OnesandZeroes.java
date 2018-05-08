package DynamicProgrammimg;

//题目描述:给定一个字符串数组，每个字符串只包含0和1，再给定m个0和n个1，从数组中选出字符串，使得总的0的个数和1的个数不超过m和n，例如
//        Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3，返回4
//解法描述:dp，其实就是背包的变种，包的大小就是m个0和n个1，所以需要二维数组，由于每个元素只能使用一次，所以要倒叙更新

public class OnesandZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; ++i) {
            int ones = 0, zeros = 0;
            for (int j = 0; j < strs[i].length(); ++j) {
                if (strs[i].charAt(j) == '0') {
                    ++zeros;
                } else {
                    ++ones;
                }
            }

            for (int a = m; a >= zeros; --a) {
                for (int b = n; b >= ones; --b) {
                    dp[a][b] = Math.max(dp[a - zeros][b - ones] + 1, dp[a][b]);
                }
            }
        }

        return dp[m][n];
    }
}
