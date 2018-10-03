package Array;

import java.util.Arrays;

//变种：如果数组已经被排好序了，如何求这个index，要求运行时间是log(n)
//解法描述：用二分法进行查找
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int h = citations.length - middle;
            if (citations[middle] >= h) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return citations.length - left;
    }
}
