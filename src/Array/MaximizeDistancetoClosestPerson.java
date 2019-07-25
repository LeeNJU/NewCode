package Array;

//题目描述:给定一个数组只包含0和1，1表示被人坐，0表示没有人坐，要求找到一个位置，使得他与最近的人的距离最大，例如[1,0,0,0,1,0,1]，坐在下标2的位置，最大距离是2
//解法描述:扫描，记录上一个位置的下标，注意处理开头和结尾的特殊情况

public class MaximizeDistancetoClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int distance = 0;
        int index = -1;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                distance = index == -1 ? i : Math.max(distance, (i - index) / 2);
                index = i;
            }
        }

        return Math.max(distance, seats.length - index - 1);
    }
}
