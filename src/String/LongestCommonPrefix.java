package String;

//题目描述：给定一个字符串数组，找到这些字符串中最长的公共前缀
//解法描述：以第一个字符串为标本，逐一比较每个字符串的第一个元素是否相等，再比较第二个元素是否相等
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int index = 0; index < strs[0].length(); ++index) {
            for (int i = 1; i < strs.length; ++i) {
                if (index >= strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }

        return strs[0];
    }
}
