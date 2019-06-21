package String;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//题目描述:给定一个字符串string1和string2，判断能不能只添加小写字母，就可以使得string2等于string1
//解法描述:判断是不是subsequence类似

public class CamelcaseMatching {

    private boolean isSubsequence(final String string1, final String string2) {
        char[] chars1 = string1.toCharArray();
        char[] chars2 = string2.toCharArray();

        int i = 0, j = 0;
        for (; i < chars1.length; ++i) {
            if (j < chars2.length && chars1[i] == chars2[j]) {
                ++j;
            } else if (Character.isUpperCase(chars1[i])) {
                return false;
            }
        }

        return j >= chars2.length;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries)
                .map(query -> isSubsequence(query, pattern))
                .collect(Collectors.toList());
    }
}
