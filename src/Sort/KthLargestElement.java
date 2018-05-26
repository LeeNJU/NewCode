package Sort;

//题目描述:给定一个未排序的数组，找到其中第k大的元素
//解法描述:数组中第k大的元素的下标为n - k，利用快排里面的partition操作，first指向数组开头，last指向结尾，
//        对first到last区间的进行partition操作，会返回一个下标index，如果index等于n - k，那么A[n - k]元素
//        就是结果，如果index小于n - k，first指向index的下一个元素，如果大于n - k，last指向index的上一个元素

public class KthLargestElement {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int partition(int[] nums, int p, int q) {
        int index = p - 1;
        int pivot = nums[q];
        for (int i = p; i < q; ++i) {
            if (nums[i] < pivot) {
                swap(nums, ++index, i);
            }
        }

        swap(nums, ++index, q);
        return index;
    }

    public int kthLargestElement(int k, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = partition(nums, left, right);
            if (middle == nums.length - k) {
                return nums[middle];
            } else if (middle < nums.length - k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return nums[left];
    }
}
