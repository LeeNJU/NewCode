package String;

//题目描述:给定两个字符串，判断是不是one edit distance
//解法描述:遍历，找到第一个不同的字符

public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1)
                            .equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i)
                            .equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1)
                            .equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
