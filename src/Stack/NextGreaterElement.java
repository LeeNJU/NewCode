package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//题目描述:给定两个数组，都不包含重复元素，nums1 = [4,1,2], nums2 = [1,3,4,2]，对于nums1中的元素，找到下一个
//        大的元素，例如nums2中，4之后没有比4大的元素，所以是-1,1后面比1大的元素是3，所以是3,2后面没有元素，所
//        以是-1
//解法描述:用stack保存一个递减的序列，例如[9,5,3,1],当下一个元素是4的时候，4比1和3都大，所以3和1的下一个比较大
//        的元素是4，用hashtable保存，然后把4压入栈中。

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.add(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
