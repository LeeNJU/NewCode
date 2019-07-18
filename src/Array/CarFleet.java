package Array;

import java.util.TreeMap;
import java.util.stream.IntStream;

//题目描述:speed数组代表车的速度，position数组代表车的起始位置，target代表终点的位置，所有的车同时按照自己的速度行驶，如果一个车速度快，追上了前面的车，那么会以前面
//        的车速度一起行驶，从而形成一个车队，求最终有多少个这样的车队，例如target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]，最终会有3个车队
//解法描述:把车进行排序，离终点近的在前面，离终点远的在后面，然后计算每辆车到达终点的时间，如果后一辆车到达终点的时间比前面的车快，说明会追上前面的车形成车队，如果时间
//        比前面的车慢，那么这个车会成为新车队的第一辆车

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
        IntStream.range(0, position.length)
                .forEach(index -> map.put(-position[index], 1.0 * (target - position[index]) / speed[index]));

        double time = 0.0;
        int count = 0;
        for (int key : map.keySet()) {
            double t = map.get(key);
            if (t > time) {
                ++count;
                time = t;
            }
        }

        return count;
    }
}
