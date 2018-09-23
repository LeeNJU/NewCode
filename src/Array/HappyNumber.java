package Array;

import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个整数n，判断是否是happy number， 例如19是happy number：
//解法描述:用哈希set保存中间算出的值

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            set.add(n);

            int num = 0;
            while (n > 0) {
                int digit = n % 10;
                num += digit * digit;
                n /= 10;
            }

            if (num == 1) {
                return true;
            }

            n = num;
        }

        return false;
    }
}
