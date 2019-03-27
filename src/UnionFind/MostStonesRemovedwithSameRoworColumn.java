package UnionFind;

import java.util.Arrays;
import java.util.stream.IntStream;

//题目描述:给定一个二维数组，非0元素代表石头，每一个操作可以移除一个在相同行或者相同列的石头，求最多可以进行多少个操作
//解法描述:union find，进行分组，求出每个组的大小

public class MostStonesRemovedwithSameRoworColumn {

    private int root(int i, int[] vec) {
        while (i != vec[i]) {
            i = vec[i];
        }

        return i;
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] vec = new int[n];
        // count表示每个分组有多少个节点
        int[] count = new int[n];
        Arrays.fill(count, 1);
        IntStream.range(0, vec.length)
                .forEach(i -> vec[i] = i);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int root1 = root(i, vec);
                    int root2 = root(j, vec);
                    // 合并两个分组，并且更新count
                    if (root1 != root2) {
                        vec[root1] = root2;
                        count[root2] += count[root1];
                        count[root1] = 0;
                    }
                }
            }
        }

        return Arrays.stream(count)
                .filter(num -> num > 0)
                .map(num -> num - 1)
                .sum();
    }
}
