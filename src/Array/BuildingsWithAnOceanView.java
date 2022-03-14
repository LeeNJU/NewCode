package Array;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个int数组表示房子的高度,数组右边是海,求所有能够看到海的房子的index，从小到大排序,例如heights = [4,2,3,1]，返回[0,2,3],只有[0,2,3]的房子可以看到海
//解法描述:一个房子必须比右边的所有房子高才能看到海，所以从右向左遍历，保存最大房子高度

public class BuildingsWithAnOceanView {

  public int[] findBuildings(int[] heights) {
    int highest = 0;
    List<Integer> list = new ArrayList<>();

    for (int i = heights.length - 1; i >= 0; --i) {
      if (heights[i] > highest) {
        list.add(i);
      }

      highest = Math.max(highest, heights[i]);
    }

    int[] result = new int[list.size()];
    for (int i = list.size() - 1; i >= 0; --i) {
      result[i] = list.get(i);
    }

    return result;
  }
}
