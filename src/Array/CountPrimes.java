package Array;

//题目描述:给定一个值n，求出比1到n的质数的个数
//解法描述:思路是3是质数，那么3的所有倍数都不是质数，5是质数，那么5的所有倍数都不是质数

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; ++j) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }
}
