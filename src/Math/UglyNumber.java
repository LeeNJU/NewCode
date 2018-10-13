package Math;

//题目描述：ugly number是指只能被2，3和5整除的数，判断一个数是不是ugly number，1是ugly number
//解法描述：不停的用2，3和5去除，如果发现除了2，3和5的约数，就不是ugly number
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    // 变种2:求出第n个ugly number
    // 解法描述:找出生成ugly number的规律，一个ugly number都是由一个较小的ugly number乘以2，3或5得到，index2，
    // index3和index5用来表示前一个较小的ugly number,每一个元素可以乘以2，3或者5去得到下一个ugly number，index2，index3和index5代表每个元素分别乘以2，3和5的可能性，index加1
    // 表示当前元素乘以2，3或者5的可能性已经被考虑过了，必须考虑下一个元素乘以2，3或者5的可能
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = Math.min(Math.min(result[index2] * 2, result[index3] * 3), result[index5] * 5);

            // 注意这里，不能用if else，因为当前最小的ugly number可能乘以2，3或者5同时得到
            if (result[i] == result[index2] * 2) {
                ++index2;
            }

            if (result[i] == result[index3] * 3) {
                ++index3;
            }

            if (result[i] == result[index5] * 5) {
                ++index5;
            }
        }

        return result[n - 1];
    }
}
