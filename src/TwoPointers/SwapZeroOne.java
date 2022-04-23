package TwoPointers;

//题目描述:给定一个数组,只包含0和1,现在只允许交换相邻的两个元素,求最少需要多少次交换可以使得数组排好序,例如
//       nums = [1,0,1,1,0,0,0,1], Output: 10
//题目解法:two pointer的解法，遍历数组，记录1的个数为count，如果当前元素为0，需要交换count次，累加count

public class SwapZeroOne {

  public int swapZeroOne(int[] nums) {
    int count = 0;
    int result = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
        ++count;
      } else {
        result += count;
      }
    }

    return result;
  }
}
