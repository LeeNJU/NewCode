package Array;

//题目描述:有n个flight，用1到n表示，现在有如下booking，booking = {1, 3, 10}，表示1到3的flight预定了10个位子，求每个flight的位子数量，例如
//        bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5,返回[10,55,45,25,25]
//解法描述:对于每个区间[i, j],i位置加k，j + 1位置减去k，然后累加

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; ++i) {
            result[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                result[bookings[i][1]] -= bookings[i][2];
            }
        }

        for (int i = 1; i < n; ++i) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
