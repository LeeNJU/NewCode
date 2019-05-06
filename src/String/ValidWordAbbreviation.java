package String;

//题目描述:给定一个字符串word和缩写字符串abbr，判断word能否匹配abbr，字母必须匹配，数字表示有多少个字符，例如s = "internationalization", abbr = "i12iz4n":返回true
//解法描述:循环遍历，字母必须匹配，如果是数字，跳过对应的字母，最后两个下表i和j必须同时等于字符串长度

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            // 注意这里，如果有0，则不能匹配
            if (abbr.charAt(j) == '0') {
                return false;
            }

            if (Character.isDigit(abbr.charAt(j))) {
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + abbr.charAt(j) - '0';
                    ++j;
                }

                i += num;
            } else if (word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
            } else {
                return false;
            }
        }

        // 注意这里
        return i == word.length() && j == abbr.length();
    }
}
