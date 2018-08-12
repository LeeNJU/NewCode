package Array;

//题目描述:给定一个数组，把每一个元素替换成右边最大的元素，最右边的元素永远替换成-1，例如Give nums = [16, 17, 4, 3, 5, 2], change nums to [17, 5, 5, 5, 2, -1]
//解法描述:从倒数第二个元素遍历，保存最右边的最大元素

public class ReplaceWithGreatestFromRight {

    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        int max = nums[nums.length - 1];
        nums[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            int num = nums[i];
            nums[i] = max;
            max = Math.max(max, num);
        }
    }
}
