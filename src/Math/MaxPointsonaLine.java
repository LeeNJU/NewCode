package Math;

import java.util.HashMap;

//题目描述：给定一个点的数组，找到一条直线，使得直线上的点最多，返回最多的点数,例如[[1,1],[2,2],[3,3]]，这三个点都在一条直线上，所以返回3
//解法描述：以点为中心，求出与剩下的点所组成的斜率，斜率相同，则在同一条直线上，记录点的数量

public class MaxPointsonaLine {

    private int generateGCD(int x, int y) {
        if (y == 0) {
            return x;
        }

        return generateGCD(y, x % y);
    }

    public int maxPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int duplicate = 0;
            int count = 1;
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                // 出现相同的点
                if (x == 0 && y == 0) {
                    ++duplicate;
                    continue;
                }

                // 斜率不能用double来存，会出现精度问题
                int gcd = generateGCD(x, y);
                x /= gcd;
                y /= gcd;

                final String slope = x + ":" + y;
                if (!map.containsKey(slope)) {
                    map.put(slope, 2);
                } else {
                    map.put(slope, map.get(slope) + 1);
                }

                count = Math.max(count, map.get(slope));
            }

            result = Math.max(result, count + duplicate);
        }

        return result;
    }
}
