package DynamicProgrammimg;

//题目描述:给n个房子涂色，cost[i][0]表示给房子i图红色的cost,cost[i][1]表示给房子i图绿色的cost,cost[i][2]表示给房子i图蓝色的cost，要求相邻两个房子颜色不能相同，求最少
//        的cost
//解法描述:dp,不能只用dp[i],因为无法知道当前的最小值是通过图哪种颜色得到的，所以继续划分状态，得到三种状态，就可以满足相邻房子颜色不同，由于只需要前一个房子的信息，可以是
//        常数空间

public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int red = costs[0][0], green = costs[0][1], blue = costs[0][2];
        for (int i = 1; i < costs.length; ++i) {
            int r = Math.min(green, blue) + costs[i][0];
            int g = Math.min(red, blue) + costs[i][1];
            int b = Math.min(red, green) + costs[i][2];

            red = r;
            green = g;
            blue = b;
        }

        return Math.min(red, Math.min(green, blue));
    }

    // 题目描述:现在有k个颜色，求最小的cost
    // 解法描述:只需要保存k个颜色中cost最小和第二小的值，以及最小值的下标，不需要保存数组
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int min1 = 0;
        int min2 = 0;
        int index1 = 0;

        for (int i = 0; i < costs.length; ++i) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, index2 = 0;
            for (int j = 0; j < costs[i].length; ++j) {
                int cost = costs[i][j] + (j == index1 ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    index2 = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }

            index1 = index2;
            min1 = m1;
            min2 = m2;
        }

        return min1;
    }
}
