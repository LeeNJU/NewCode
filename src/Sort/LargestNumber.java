package Sort;

import java.util.Arrays;

//题目描述:给定一个数组，把这些数组里的数拼接起来，使其形成的数最大，例如[3, 30, 34, 5, 9]，形成的最大数
//         为9534330
//解法描述:关键是判断任意两个数a和b的先后顺序，先把数子转成string，然后通过比较a + b和b + a的大小来判断,
//         以此来排序，然后进行拼接，注意全是0的情况

public class LargestNumber {

    public String largestNumber(int[] nums) {
        Integer[] elements = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            elements[i] = new Integer(nums[i]);
        }

        Arrays.sort(elements, (a, b) -> {
            String str1 = Integer.toString(a);
            String str2 = Integer.toString(b);
            return (str2 + str1).compareTo(str1 + str2);
        });

        String result = "";
        for (Integer num : elements) {
            result += Integer.toString(num);
        }

        if (result.length() > 0 && result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}
