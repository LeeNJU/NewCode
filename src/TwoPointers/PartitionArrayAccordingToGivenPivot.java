package TwoPointers;

//题目描述:给定一个整数数组和一个pivot值,对数组的元素重新排序,是的小于pivot的元素在前面,大于pivot的元素在后面,中间是等于pivot的元素,元素的相对顺序不变,例如
//       nums = [9,12,5,10,14,3,10], pivot = 10, 返回[9,5,3,10,10,12,14]
//解法描述:不能in-place完成, 扫描数组找到大于pivot元素的起点坐标，等于pivot元素的起点坐标，然后遍历原数组，依次放入对应的为止

public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int low = 0, same = 0, high = nums.length;
        for (int num : nums) {
            // 找到等于pivot元素的起始坐标
            if (num < pivot) {
                ++same;
            // 找到大于pivot元素的起始坐标
            } else if (num > pivot) {
                --high;
            }
        }

        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num < pivot) {
                result[low++] = num;
            } else if (num > pivot) {
                result[high++] = num;
            } else {
                result[same++] = num;
            }
        }
        return result;
    }
}
