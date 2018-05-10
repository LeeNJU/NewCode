package DynamicProgrammimg;

//题目描述:给定一个字符串s,找出decode的方式，"1"对应A，"12"可以被decode为"AB"或者"L"，所以有2种方式
//解法描述:动态规划，s[i] == '0'的时候,不能被单独decode，必须前面是1或者2才能被decode.所以是dp[i + 2] =
//        dp[i],如果s[i] != '0',可以被单独decode,dp[i + 2] = dp[i + 1], 这时还要看当前元素是不是能和前一
//        个元素构成合理的decode方式,所以还要再加上dp[i + 2] += dp[i]

public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        dp[0] = 1;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                dp[i + 1] += dp[i - 1];
            }

            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }
}
