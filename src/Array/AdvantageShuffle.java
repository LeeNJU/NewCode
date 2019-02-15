package Array;

import java.util.Arrays;
import java.util.TreeMap;

//题目描述:给定两个长度相同的数组A和B，定义A的advantage如下，A[i]>B[i]，返回A的任意排列，使得A的advantage最大，例如A = [2,7,11,15], B = [1,10,4,11]， Output: [2,11,7,15]
//解法描述:用treemap记录A元素的次数，利用treemap的ceiling方法

public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Arrays.stream(A)
                .forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        int[] result = new int[A.length];
        for (int i = 0; i < B.length; ++i) {
            // ceiling元素不存在就用最小的元素替代
            result[i] = map.ceilingKey(B[i] + 1) != null ? map.ceilingKey(B[i] + 1) : map.firstKey();
            map.put(result[i], map.get(result[i]) - 1);
            if (map.get(result[i]) == 0) {
                map.remove(result[i]);
            }
        }

        return result;
    }
}
