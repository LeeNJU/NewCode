package Math;

//题目描述:给定一个整数c，判断有没有两个整数a和b，使得a^2 + b^2 = c
//解法描述:双指针扫描

public class SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {
        // 注意这里要开方，否则乘积可能会溢出
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum < c) {
                ++left;
            } else if (sum > c) {
                --right;
            } else {
                return true;
            }
        }

        return false;
    }
}
