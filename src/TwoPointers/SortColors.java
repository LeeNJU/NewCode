package TwoPointers;

//给定一个数组，包含0,1,2，给数组进行排序，不能使用sort方法
//解法：用双指针，一个指针指向开头，[0,red - 1]表示全是0， 一个指针指向后面，[blue + 1, n - 1]表示全是2， 中间为1，循环整个数组，把2往后交换，把0往前交换，复杂度为O(n)
//注意：交换两个元素之后，不能进行++i，因为交换后的元素可能相同

public class SortColors {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int red = -1, blue = nums.length;
        for (int i = 0; i < blue;) {
            if (nums[i] == 2) {
                swap(nums, i, --blue);
            } else if (nums[i] == 0) {
                swap(nums, ++red, i++);
            } else {
                ++i;
            }
        }
    }

    // 题目描述:假设有k个颜色，进行排序
    // 解法描述:依次排列每种颜色，例如先保证所有的1在左边，然后是所有的2，以此类推。

    public void sortColors2(int[] colors, int k) {
        int color1 = 1, color2 = k;
        int left = 0, right = colors.length - 1;
        int p = left - 1, q = right + 1;
        while (color1 < color2) {
            // 注意这里i必须小于1q
            for (int i = left; i <= right && i < q;) {
                if (colors[i] == color1) {
                    swap(colors, ++p, i++);
                } else if (colors[i] == color2) {
                    swap(colors, i, --q);
                } else {
                    ++i;
                }
            }

            left = p + 1;
            right = q - 1;
            ++color1;
            --color2;
        }
    }
}
