package Array;

//题目描述:给定一个正数，最多只能交换一次数字，求能得到的最大数字，例如2736，交换一次得到7236
//解法描述:记录每个数字最后出现的下标，从高位遍历，在低位找到一个比当前数字大的数字然后交换

public class MaximumSwap {

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();

        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;

        return new String(chars);
    }

    public int maximumSwap(int num) {
        int[] buckets = new int[10];
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); ++i) {
            buckets[s.charAt(i) - '0'] = i;
        }

        for (int i = 0; i < s.length(); ++i) {
            for (int k = 9; k > s.charAt(i) - '0'; --k) {
                // 找到了比当前数字大的数字
                if (buckets[k] > i) {
                    return Integer.parseInt(swap(s, i, buckets[k]));
                }
            }
        }

        return num;
    }
}
