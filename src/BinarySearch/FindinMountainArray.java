package BinarySearch;

import Util.MountainArray;

//题目描述:给定一个moutain数组A，就是A[0] < A[1] < ... < A[i] > A[i + 1] > A[i + 2] > ... > A[n - 1],找到target元素的最小下标，例如
//       array = [1,2,3,4,5,3,1], target = 3,3出现了两次，返回最小的下标2
//解法描述:先用二分找到最大的元素，得到两个升序和降序的数组，分别二分

public class FindinMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left;
        left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = peak + 1;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
