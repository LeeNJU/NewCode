package String;

//题目描述:给定一个字符串，包含多个单词，每个单词用一个或多个空格隔开，开头和结尾可能有空格，要求对反转字符串，
//        最后一个单词放在第一的位置，倒数第二个单词放在第二的位置，每个单词用一个空格隔开，开头和结尾不能有
//        空格
//解法描述:从后往前扫描
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        char[] arrays = s.toCharArray();
        int j = s.length() - 1;
        while (j >= 0) {
            while (j >= 0 && arrays[j] == ' ') {
                --j;
            }

            int i = j;
            while (j >= 0 && arrays[j] != ' ') {
                --j;
            }

            int index = j + 1;
            while (index <= i) {
                result.append(arrays[index++]);
            }

            result.append(' ');
        }

        return result.toString()
                .trim();
    }
}
