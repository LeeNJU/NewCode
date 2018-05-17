package String;

//题目描述：给定一个只包含字母和空格的字符串，求出最后一个单词的长度，例如"Hello World"的最后一个单词长度为5
//解法描述：从后扫描，先找到第一个非空字符，然后再往前扫描，直到碰到一个空格或者下标等于0
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) != ' ') {
            --i;
        }

        return str.length() - i - 1;
    }
}
