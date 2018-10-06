package DynamicProgrammimg;

//题目描述:给定一个字符串，代表学生的出勤记录，A代表absent，P代表present，L代表late，A的次数不能超过1，并且不能有三个连续的LLL
//解法描述:遍历统计

public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A') {
                ++A;
            } else if (i > 1 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                ++L;
            }
        }

        return A <= 1 && L == 0;
    }
}
