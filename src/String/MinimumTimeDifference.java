package String;

import java.util.Collections;
import java.util.List;

//题目描述:给定一个时间点的list，格式为HH:MM, 找到两个时间点，使得这两个时间点的差最小，例如["23:59","00:00"]，两个时间点差1
//解法描述:当前的时间点格式可以直接排序，然后依次比较相邻两个时间点的差值，特殊情况在于第一个时间和第二个时间的差值要加上1440分钟。

public class MinimumTimeDifference {

    private int diff(final String time1, final String time2) {
        int hour1 = Integer.parseInt(time1.substring(0, 2));
        int minute1 = Integer.parseInt(time1.substring(3, 5));
        int hour2 = Integer.parseInt(time2.substring(0, 2));
        int minute2 = Integer.parseInt(time2.substring(3, 5));

        return (hour2 - hour1) * 60 + minute2 - minute1;
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); ++i) {
            // 注意这里 比较最后一个时间点和第一个时间
            int diff = diff(timePoints.get(i), timePoints.get((i + 1) % timePoints.size()));

            if (i == timePoints.size() - 1) {
                diff += 24 * 60;
            }

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
