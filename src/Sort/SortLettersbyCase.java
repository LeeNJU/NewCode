package Sort;

//题目描述:给定一个字符数组，只包含字母，进行排序，使得小写字母在前面，大写字母在后面，例如"abAcD"，排序之后可能的答案之一是"acbAD"
//解法描述:双指针

public class SortLettersbyCase {

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public void sortLetters(char[] chars) {
        for (int i = -1, j = 0; j < chars.length; ++j) {
            if (Character.isLowerCase(chars[j])) {
                swap(chars, ++i, j);
            }
        }
    }
}
