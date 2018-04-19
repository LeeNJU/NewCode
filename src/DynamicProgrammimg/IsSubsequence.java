package DynamicProgrammimg;

//题目描述:给定一个字符串s和t，t非常长，判断s是不是t的一个子序列，例如s="abc", t="ahbgdc",返回true
//解法描述:用两个指针i和j扫描字符串，如果s[i]和t[j]相等，表示匹配了一个字符，i向后移动，如果不匹配，i不动，j
//        继续向后移动。当匹配结束时，如果i还有剩余的字符串，说明不存在这样的自序列，如果i已经大于等于s的长度，
//        说明匹配。
//follow-up:如果有很多的字符串s，例如S1,S2,S3,需要每次都进行这样的判断吗
//解法描述:把字符串t建成索引，记录每个字符的下标集合，然后对于每个s，遍历s，对其中的每一个字符进行二分查找

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }

        return i >= s.length();
    }
}
