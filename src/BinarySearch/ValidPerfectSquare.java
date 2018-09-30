package BinarySearch;

//题目描述:给定一个正整数，判断其是不是一个平方数，例如给定16，返回true
//解法描述:二分查找，注意溢出

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (num / middle < middle) {
                right = middle - 1;
            } else if (num / middle > middle) {
                left = middle + 1;
            } else if (middle * middle == num) {
                return true;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
