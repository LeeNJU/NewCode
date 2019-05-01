package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//题目描述:给定n个课程，(t, d)t表示课程的时长，d表示截止日期，求出最多能上多少门课，例如[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]，最多能上3门，
//       上[100, 200], [1000, 1250], [200, 1300]
//解法描述:根据截止日期排序，先上截止日期近的课程，把上过的课程根据时长放入最大堆里，遍历课程，如果课程不能在截止日期前完成，就把之前时长最长的课程去掉

public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        // 用最大优先级队列存储已经选择了的课程
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.add(course[0]);

            // 如果当前考虑的课程超期了，就从已选择的课程中去掉课时最长的
            if (time > course[1]) {
                time -= pq.poll();
            }
        }

        // 最终优先级队列中的课程数，就是能够选择的最多课程
        return pq.size();
    }
}
