package Array;

import java.util.HashMap;

//题目描述：把罗马数字转换成int，规则:I=1, V=5,X=10,L=50,C=100,D=500,M=1000,相同数字连写，表示数字相加，小
//         数字在大数字右边，表示数字相加，小数字在大数字左边，表示大数字减去小数字
//解法描述：从左往右扫描,当遇到相同数字连写或者小数字在大数字右边时，都是表示直接把数字相加，而当小数字在大数
//         字左边的时候，表示大数字减去小数字

public class RomantoInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            result += hashMap.get(s.charAt(i));
            if (i > 0 && hashMap.get(s.charAt(i)) > hashMap.get(s.charAt(i - 1))) {
                result -= 2 * hashMap.get(s.charAt(i - 1));
            }
        }

        return result;
    }
}
