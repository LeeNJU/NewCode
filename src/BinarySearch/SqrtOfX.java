package BinarySearch;

//题目描述：给定一个值x，求出它的平方根
//解法描述：二分查找

public class SqrtOfX {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // 注意这里循环的方式，while用小于等于，那么middl必须是加1或者减1，否则会出现死循环
        int left = 1, right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle == x / middle) {
                return middle;
            } else if (middle < x / middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
}
