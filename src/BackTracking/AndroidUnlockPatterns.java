package BackTracking;

//题目描述:android解锁模式，给定一个3*3的数字，从1到9，再给定m和n，表示解锁模式的最小和最大长度，求所有可能的
//        解锁模式的个数，如果两个数字经过了一个数字，那么中间的数字必须在之前被访问过，例如1到9，中间会经过5，
//        那么5在之前必须被访问过。
//解法描述:dfs,用二维数组表示每两个数字之间的数字，以及当前路径上已经访问过的数字，进行dfs，其中1,3,5,9是对称的
//        2,4,6,8也是对称的，以及中间一个5，所以只需要以1开始的结果，乘以4,2开始的结果乘以4，加上5开始的结果

public class AndroidUnlockPatterns {

    private int dfs(int m, int n, int len, int num, int[][] hash, boolean[] visited) {
        int count = 0;
        if (len >= m) {
            count++;
        }

        if (++len > n) {
            return count;
        }

        visited[num] = true;
        for (int i = 1; i <= 9; ++i) {
            // 下一个数字没有被访问过，并且中间数字已经被访问过
            if (!visited[i] && visited[hash[num][i]]) {
                count += dfs(m, n, len, i, hash, visited);
            }

        }
        visited[num] = false;

        return count;
    }

    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];
        visited[0] = true;
        int[][] hash = new int[10][10];

        hash[1][3] = hash[3][1] = 2;
        hash[4][6] = hash[6][4] = 5;
        hash[7][9] = hash[9][7] = 8;
        hash[1][7] = hash[7][1] = 4;
        hash[2][8] = hash[8][2] = 5;
        hash[3][9] = hash[9][3] = 6;
        hash[1][9] = hash[9][1] = hash[3][7] = hash[7][3] = 5;

        return dfs(m, n, 1, 1, hash, visited) * 4 + dfs(m, n, 1, 2, hash, visited) * 4 + dfs(m, n, 1, 5, hash, visited);
    }
}
