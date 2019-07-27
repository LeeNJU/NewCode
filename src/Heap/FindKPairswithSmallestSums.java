package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

//题目描述:给定两个已序数组，找到最小的k个pair，使得他们的和最小，例如nums1 = [1,7,11], nums2 = [2,4,6], k = 3，返回[[1,2],[1,4],[1,6]] 
//解法描述:两个元素的两两组合形成一个二维数组，类似于k个数组里面找最小的元素的思路，用最小堆处理

public class FindKPairswithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>(
                (pair1, pair2) -> nums1[pair1.getKey()] + nums2[pair1.getValue()] - nums1[pair2.getKey()] - nums2[pair2.getValue()]);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        for (int i = 0; i < nums1.length; ++i) {
            queue.add(new Pair<Integer, Integer>(i, 0));
        }

        while (k > 0 && !queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            result.add(Arrays.asList(nums1[pair.getKey()], nums2[pair.getValue()]));

            if (pair.getValue() + 1 < nums2.length) {
                queue.add(new Pair<Integer, Integer>(pair.getKey(), pair.getValue() + 1));
            }

            --k;
        }

        return result;
    }
}
