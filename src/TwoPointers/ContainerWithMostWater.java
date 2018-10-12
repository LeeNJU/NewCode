package TwoPointers;

//题目描述：给定一个数组，a0,a1,a2,..每一个点代表一条线段(i,0)和(i,ai)，找出两条线段，使这两条线段与x轴形成的面积最大
//解法描述：贪心，两个指针往中间移动，保持最大的面积

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;

        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));

            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}
