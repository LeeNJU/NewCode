package DynamicProgrammimg;

//题目描述:给定一个字符串只包含0和1，可以把0变成1，也可以把1变成0，求最小需要几步操作，可以使得字符串左边全是0，右边全是1，例如"00110"，最后一个0变成1得到"00111"
//解法描述:dp,最后的结果分成两种状态，one表示当前字符串以1结尾需要flip几次，zero表示当前字符串以0结尾需要flip几次

public class FlipStringtoMonotoneIncreasing {

    public int minFlipsMonoIncr(String S) {
        int one = S.charAt(0) == '1' ? 0 : 1;
        int zero = S.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i) == '1') {
                one = Math.min(one, zero);
                zero = zero + 1;
            } else {
                zero = zero;
                one = one + 1;
            }
        }

        return Math.min(one, zero);
    }
}
