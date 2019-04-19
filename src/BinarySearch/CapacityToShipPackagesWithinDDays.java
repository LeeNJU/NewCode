package BinarySearch;

//题目描述:给定一个整数数组代表货物重量，再给一个次数D，找到最小的运载量，可以把所有的货物按照已有的顺序在D次内搬运完，例如weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//        最小载重量是15，1st day: 1, 2, 3, 4, 5  2nd day: 6, 7  3rd day: 8  4th day: 9  5th day: 10
//解法描述:对于最小载重量进行二分查找

public class CapacityToShipPackagesWithinDDays {

    // 对于给定的某个载重量，判断能不能在D次内把货物运完
    private boolean canLoad(int[] weights, int D, int capacity) {
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
            if (totalWeight > capacity) {
                --D;
                totalWeight = weight;
            }
        }

        return D >= 1;
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = 1, right = 0;
        // 载重量必须大于等于当个货物的重量
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (canLoad(weights, D, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
