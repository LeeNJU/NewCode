package BinarySearch;

//题目描述:给定两个有序数组，找到中位数，例如nums1 = [1, 3]，nums2 = [2]，中位数是2
//解法描述:转换成第k小的元素，复杂度是log(m + n)

public class MedianoftwoSortedArrays {

    private double find_kth(int[] A, int index1, int[] B, int index2, int k) {
        // 默认A数组要小
        if (A.length > B.length) {
            return find_kth(B, index2, A, index1, k);
        }

        // A数组为空，说明第K小的元素在数组B中
        if (index1 >= A.length) {
            return B[index2 + k - 1];
        }

        if (index2 >= B.length) {
            return A[index1 + k - 1];
        }

        // 找第1小的元素
        if (k == 1) {
            return Math.min(A[index1], B[index2]);
        }

        // 注意pb的算法，k-pa可以使pa和pb加起来等于k
        int pa = Math.min(k / 2, A.length - index1), pb = k - pa;

        // 如果小于，表示数组A的pa-1位置以下的元素都不是，可以删除
        if (A[index1 + pa - 1] < B[index2 + pb - 1]) {
            return find_kth(A, index1 + pa, B, index2, k - pa);
            // 如果大于，表示数组B的pb - 1下标以下的元素都不是第k小的元素，可以删除
        } else if (A[index1 + pa - 1] > B[index2 + pb - 1]) {
            return find_kth(A, index1, B, index2 + pb, k - pb);
            // 相等，表示这就是第k小的元素，因为pa+pb等于k
        } else {
            return A[index1 + pa - 1];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int total = nums1.length + nums2.length;
        // 奇数
        if (total % 2 == 1) {
            return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
            // 偶数
        } else {
            return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
        }
    }
}
