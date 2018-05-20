package String;

//题目描述:给定一个字符串，包含多个单词，每个单词用一个或多个空格隔开，开头和结尾可能有空格，要求对反转字符串，
//        最后一个单词放在第一的位置，倒数第二个单词放在第二的位置，每个单词用一个空格隔开，开头和结尾不能有
//        空格
//解法描述:从后往前扫描
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");

        String result = "";
        for (int i = strings.length - 1; i >= 0; --i) {
            if (strings[i].length() == 0) {
                continue;
            }

            result += strings[i] + " ";
        }

        return result.trim();
    }
}
