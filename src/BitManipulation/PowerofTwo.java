package BitManipulation;

//题目描述:给定一个数，判断是不是2的幂
//解法描述:必须大于0，并且 n & (n - 1) 必须等于0

public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        return (n > 0 && ((n & (n - 1)) == 0));
    }
}
