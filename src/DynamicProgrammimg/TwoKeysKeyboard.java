package DynamicProgrammimg;

//题目描述:刚开始只有一个字符A，可以通过copy操作和paste操作增加A的个数，求得到n个A字符，最少需要几步操作，例如n = 3，copy一次，复制两次得到AAA
//解法描述:dp[i] = dp[j] + i / j,其中j可以被i整除，一定需要是倍数才可以复制得到当前的字符

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i < n + 1; ++i) {
            // 可以用第一个字符A复制i次
            dp[i] = i;

            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + (i / j), dp[i]);
                }
            }
        }

        return dp[n];
    }
}
