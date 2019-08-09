package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述:给定一个字符串数组，找到在所有字符串中出现的公共字符，例如["bella","label","roller"]，返回["e","l","l"]，e在所有字符串中出现至少1一次，l在所有字符串中出现至少2次
//解法描述:对每一个字符串统计字符的出现次数，对每一个字符保留最小值

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (int i = 0; i < A.length; ++i) {
            int[] freq = new int[26];
            for (int j = 0; j < A[i].length(); ++j) {
                ++freq[A[i].charAt(j) - 'a'];
            }

            for (int j = 0; j < freq.length; ++j) {
                count[j] = Math.min(count[j], freq[j]);
            }
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                --count[i];
            }
        }

        return result;
    }
}
