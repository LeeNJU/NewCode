package String;

import java.util.ArrayList;
import java.util.List;

//题目描述:字符串加密和解密，给定一个字符串数组，把字符串编码成一个字符串，然后对这个字符串解码得到原来的字符串数组
//解法描述:编码规则，首先是字符串的长度，然后用一个特殊字符作为每个字符串的起始sentinel(如果不用sentinel,无法得到字符串长度，因为字符串开头可能本身就包含数字)，
//        然后是字符串
public class EncodeandDecodeStrings {

    public String encode(List<String> strs) {
        return strs.stream()
                .map(str -> Integer.toString(str.length()) + "#" + str)
                .reduce((str1, str2) -> str1 + str2)
                .orElse("");
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length();) {
            int index = s.indexOf("#", i);
            int length = Integer.parseInt(s.substring(i, index));
            result.add(s.substring(index + 1, index + length + 1));
            i = index + length + 1;
        }
        return result;
    }
}
