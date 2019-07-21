package Array;

//题目描述:给定一个整数数组代表高度，判断能装多少水，例如[0,1,0,2,1,0,1,3,2,1,2,1]，返回6
//解法描述:遍历每一个高度，判断当前位置能装多少水，当前位置如果能装水，必须确保两边都有更高的wall可以挡住，所以需要得到两边的最大高度

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int sum = 0;

        while (left <= right) {
            // left高度比right低，right可以当做右边的wall，maxLeft就是左边的wall
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                sum += maxLeft - height[left];
                ++left;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                sum += maxRight - height[right];
                --right;
            }
        }

        return sum;
    }
}
