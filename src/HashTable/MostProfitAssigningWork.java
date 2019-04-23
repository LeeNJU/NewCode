package HashTable;

import java.util.TreeMap;
import java.util.stream.IntStream;

//题目描述:给定三个数组,difficulty表示任务的难度，profit表示任务的利润，worker表示工人能完成的最大任务难度，现在给每个工人分配一个任务，使得他们的例如最大，例如
//       difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7],工人分别做任务[4,4,6,6], 分别得到的利润是[20,20,30,30]
//解法描述:建立难度和利润的映射，由于可能同一个难度对应不同的利润，难度必须对应最大利润，其次难度低的可能利润更大，treemap里面的映射表示的是难度小于等于当前难度的最大利润
//        然后对于每个工人，利用treemap的二分搜索进行查找求和

public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        // key是难度 value是profit，根据难度排序
        IntStream.range(0, difficulty.length)
                .forEach(index -> map.put(difficulty[index], Math.max(profit[index], map.getOrDefault(difficulty[index], 0))));

        // 求出难度小于等于当前难度的最大利润
        int curProfit = 0;
        for (int key : map.keySet()) {
            curProfit = Math.max(curProfit, map.get(key));
            map.put(key, curProfit);
        }

        int result = 0;
        for (int work : worker) {
            Integer floorKey = map.floorKey(work);
            if (floorKey != null) {
                result += map.get(floorKey);
            }
        }

        return result;
    }
}
