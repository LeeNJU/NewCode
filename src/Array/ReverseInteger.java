package Array;

//题目描述:给定一个整数，把这个整数反转，123->321
//解法描述:依次去最后一位进行反转，注意两点：result可能会溢出，要进行判断，其次当x=INT_MIN时要单独处理

public class ReverseInteger {

    public int reverse(int x) {
        // 单独处理，因为-INT_MIN会溢出
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int result = 0;
        int value = x > 0 ? x : -x;
        while (value > 0) {
            int digit = value % 10;
            // 检查溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            result = result * 10 + digit;
            value /= 10;
        }
        return x > 0 ? result : -result;
    }
}
