package Array;

//题目描述:给定一个非负数组表示一个很大的数，给这个数加1
//解法描述:最后一位如果小于9，直接加1然后返回，否则后面一直会是0

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
