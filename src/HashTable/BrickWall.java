package HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:给定一个二维数组，每一个数组表示砖的长度，
//解法描述:记录每个断点的频率 https://www.cnblogs.com/grandyang/p/6697067.html

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }

        return wall.size() - max;
    }
}
