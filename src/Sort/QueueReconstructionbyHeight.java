package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述:给定一个数组，表示h表示人的身高，k表示在这个人之前，身高大于等于他的个数，重新恢复数组的顺序，例如
//       [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]，[4,4]表示身高是4，在他前面身高大于等于4的人数也是4，返回
//       [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//解法描述:根据身高从大到下排序，如果身高相等，根据k值从小到大排序，经过排序后，身高最高的人的位置一定是正确的，然后开始看第二高的人，把他插入到合适的位置，
//       这不会影响前面的人的正确性，比如刚开始是[[7,0], [7,1]]，第二高的人是[6,1]，把他插入到中间[[7,0], [6,1], [7,1]]，以此类推

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<int[]>();

        for (int[] num : people) {
            list.add(num[1], num);
        }

        return list.toArray(new int[people.length][]);
    }
}
