package BinarySearch;
//题目描述:isBadVersion是系统提供的api，能够判断n是否是bad version，给定一个数n，找到第一个bad version，

//        如果n是bad version,那么n之后的元素都是bad version，因为后面是基于前面的基础
//解法描述：二分查找

public class FirstBadVersion {

    private boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, middle;
        while (left <= right) {
            // 注意这里，这种方式可以防止溢出
            middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
