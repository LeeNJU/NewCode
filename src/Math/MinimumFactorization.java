package Math;

//题目描述:给定一个整数，对其因数分解，用所有的因数组成最小的数，例如Given a = 48, return 68
//解法描述:因数只能是2到9，所以用a不断除以9，然后除以8，如果能够除尽，能够找到合理的解，如果除不尽，返回0

public class MinimumFactorization {

    public int smallestFactorization(int a) {

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 2; --i) {
            while (a % i == 0) {
                result.insert(0, i);
                a /= i;
            }
        }

        if (a > 1) {
            return 0;
        }

        long res = Long.parseLong(result.toString());
        return res > Integer.MAX_VALUE ? 0 : (int) res;
    }
}
