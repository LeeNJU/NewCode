package BackTracking;

//题目描述:给定一个数字字符串，判断其是不是additive number，例如"112358"是additive number，因为可以被分成
//        "1", "1", "2", "3", "5", "8"并且满足1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8，其中以0开头的
//        数字字符串是非法字符串，例如"02"
//解法描述:先枚举第一个数和第二个数，然后两个数相加,循环或者递归的方式判断

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i < n / 2; ++i) {
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        // 0开头的数字无效
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }

        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }

        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
