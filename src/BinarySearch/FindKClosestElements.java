package BinarySearch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//题目描述:给定一个已排好序的数组，找到k个离x最近的k个元素，例如[1,2,3,4,5], k=4, x=3，返回[1,2,3,4]
//解法描述:本质上是找大小为k的子数组，使得离x的距离最近，二分寻找这个子数组的起始位置

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (x - arr[middle] > arr[middle + k] - x) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return IntStream.range(left, left + k)
                .map(index -> arr[index])
                .boxed()
                .collect(Collectors.toList());
    }
}
