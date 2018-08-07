package BitManipulation;

//题目描述:给定一个32位整数，返回左移d位后的结果
//解法描述:通过整数的正负来判断最左边的位是0还是1

public class RotateBitsLeft {

    public int leftRotate(int n, int d) {
        d %= 32;
        while (d > 0) {
            int digit = n >= 0 ? 0 : 1;
            n <<= 1;
            n += digit;
            --d;
        }

        return n;
    }
}
