package BackTracking;

//题目描述:给定一个数字字符串，判断其是不是additive number，例如"112358"是additive number，因为可以被分成
//        "1", "1", "2", "3", "5", "8"并且满足1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8，其中以0开头的
//        数字字符串是非法字符串，例如"02"
//解法描述:先枚举第一个数和第二个数，然后两个数相加,循环或者递归的方式判断

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                if (isValid(num.substring(0, i + 1), num.substring(i + 1, j + 1), j + 1, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num1, String num2, int index, String num) {
        if ((num1.charAt(0) == '0' && num1.length() > 1) || (num2.charAt(0) == '0') && num2.length() > 1) {
            return false;
        }

        while (index < num.length()) {
            long n1 = Long.parseLong(num1);
            long n2 = Long.parseLong(num2);
            String num3 = Long.toString(n1 + n2);
            if (!num.startsWith(num3, index)) {
                return false;
            }

            index += num3.length();
            num1 = num2;
            num2 = num3;
        }

        return true;
    }
}
