package TwoPointers;

//题目描述:给定两个递减的数组nums1和nums2,如果nums[i]<= nums2[j]并且i <= j, 这就是一个pair的距离，求这样的最大距离，例如
//       nums1 = [2,2,2], nums2 = [10,10,1],有效的pair是(2,2), (2,3), (2,4), (3,3), and (3,4)，最大的距离是2, (2,4)
//解法描述:双指针,如果nums1[i] > nums2[j], 表示i元素没有解,如果nums1[i] <= nums2[j],就不断移动j，寻找最大解

public class MaximumDistanceBetweenaPairOfValues {

  public int maxDistance(int[] nums1, int[] nums2) {
    int result = 0;
    int i = 0, j = 0;

    while(i < nums1.length && j < nums2.length) {
      if(nums1[i] <= nums2[j]) {
        result = Math.max(result, j - i);
        ++j;
      } else {
        ++i;
      }
    }

    return result;
  }
}