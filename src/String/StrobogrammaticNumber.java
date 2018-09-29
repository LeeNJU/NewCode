package String;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个字符串数字，如果这些数字翻转180度，判断是否跟原来的数字字符串相等，例如"69",翻转180度后，
//        还是"69"
//解法描述:两个指针往中间走，两边翻转之后必须相等
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        // 只有这些字符翻转180度后还是一个数字
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');

        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }
}
