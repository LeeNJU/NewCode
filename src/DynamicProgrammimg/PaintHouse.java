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
}
