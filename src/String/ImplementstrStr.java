package String;

//题目描述:实现strStr，从字符串haystack中找到字符串needle第一次出现的位置，返回下标
//解法:暴力解法
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); ++i) {
            int j = 0, index = i;
            while (index < haystack.length() && j < needle.length() && haystack.charAt(index) == needle.charAt(j)) {
                ++index;
                ++j;
            }

            if (j >= needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
