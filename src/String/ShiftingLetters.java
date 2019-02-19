package String;

//题目描述:给定一个数组和一个字符串，进行如下操作，S = "abc", shifts = [3,5,9],第一个字符a加3，第一个和第二个字符a和b加5，然后前3个字符加17，返回最后的字符
//解法描述:第一个字符会增加17，第二个字符会增加14，第三个字符增加9，找到规律，先算出每个字符要增加的值

public class ShiftingLetters {

    public String shiftingLetters(String S, int[] shifts) {
        shifts[shifts.length - 1] %= 26;

        // 注意这里要取模
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }

        char[] chars = S.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
            chars[i] += shifts[i];
            if (chars[i] > 'z') {
                chars[i] -= 26;
            }
        }

        return new String(chars);
    }
}
