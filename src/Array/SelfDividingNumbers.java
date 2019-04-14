package Array;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//题目描述:给定一个区间[left, right],找到这个区间之中，符合self dividing的数字，该数字能被每一位整除，例如128，能被1,2和8整除，所以128满足条件
//解法描述:暴力遍历

public class SelfDividingNumbers {

    private boolean check(final int num) {
        if (num < 10 && num > 0) {
            return true;
        }

        int value = num;
        while (value > 0) {
            if (value % 10 == 0 || num % (value % 10) != 0) {
                return false;
            }

            value /= 10;
        }

        return true;
    }

    public List<Integer> digitDivideNums(int left, int right) {
        return IntStream.range(left, right + 1)
                .filter(this::check)
                .boxed()
                .collect(Collectors.toList());
    }
}
